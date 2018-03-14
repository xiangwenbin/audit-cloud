package com.zhonghui.auditcloud.webapp.controller;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.docx4j.XmlUtils;
import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;
import org.docx4j.wml.RFonts;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonghui.auditcloud.template.api.model.vo.ResultVo;
import com.zhonghui.auditcloud.webapp.vo.RichTextVo;

@Controller
@RequestMapping("richtext")
public class RichTextController extends BaseController {

	private String baseURL = "c:/htmldoc";
	
	
	@RequestMapping(value = { "/ueditor" })
	public String ueditor() {
		return "pages/ueditor";
	}
	
	@RequestMapping(value = { "/save" })
	@ResponseBody
	public ResultVo<String> test(@RequestBody RichTextVo richTextVo) throws Docx4JException, JAXBException {
//		String unescaped = "<html><style type=\"text/css\">table td{border:1px solid #99999;}</style>"
//				+ richTextVo.getHtml()
//				+"<table style=\"border:0;border-collapse:collapse;width:600px;\"><tbody><tr><td style=\"border:1px solid #999\">&nbsp;</td><td style=\"border:1px solid #999\">&nbsp;</td></tr><tr><td style=\"border:1px solid #999\">&nbsp;</td><td style=\"border:1px solid #999\">&nbsp;</td></tr></tbody></table>"
//				+ "<p><span style=\"font-size:16px;\">16px</span><span style=\"font-size:14px;\">14px</span></p></html>";
		String unescaped = "<html><p>16px</p>"
				+ richTextVo.getHtml()
				+ "</html>";
		System.out.println("Unescaped: " + unescaped);
		
		final Document document = Jsoup.parse(unescaped);
		Elements elements=document.getElementsByTag("table");
//		Element element=elements.get(0);
		for(Element element : elements)
			element.attr("style", "border-collapse:collapse;border:0;");
		
		document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
		unescaped = document.html();
		
		
		// <!ENTITY nbsp " ">
		// <!ENTITY copy "©">
		// <!ENTITY reg "®">
		// <!ENTITY trade "™">
		// <!ENTITY mdash "—">
		// <!ENTITY ldquo "“">
		// <!ENTITY rdquo "”">
		// <!ENTITY pound "£">
		// <!ENTITY yen "¥">
		// <!ENTITY euro "€">
		unescaped = "<!DOCTYPE xhtml [<!ENTITY nbsp \"&#160;\">]>" + unescaped;
		System.out.println("xhtml Unescaped: " + unescaped);
		// Setup font mapping
		RFonts rfonts = Context.getWmlObjectFactory().createRFonts();
		rfonts.setAscii("宋体");
		XHTMLImporterImpl.addFontMapping("宋体", rfonts);

		// Create an empty docx package
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();
		// WordprocessingMLPackage wordMLPackage =
		// WordprocessingMLPackage.load(new File(baseURL + "/styled.docx"));

		NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
		wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
		ndp.unmarshalDefaultNumbering();

		// Convert the XHTML, and add it into the empty docx we made
		XHTMLImporterImpl XHTMLImporter = new XHTMLImporterImpl(wordMLPackage);

		XHTMLImporter.setHyperlinkStyle("Hyperlink");
		wordMLPackage.getMainDocumentPart().getContent().addAll(XHTMLImporter.convert(unescaped, ""));

		System.out.println(XmlUtils.marshaltoString(wordMLPackage.getMainDocumentPart().getContents(), true, true));

		// System.out.println(
		// XmlUtils.marshaltoString(wordMLPackage.getMainDocumentPart().getNumberingDefinitionsPart().getJaxbElement(),
		// true, true));

		wordMLPackage.save(new java.io.File(baseURL + "/OUT_from_XHTML.docx"));
		return ResultVo.succ();
	}
}
