package com.zhonghui.auditcloud.webapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.hutool.core.io.file.FileReader;

/**
 * 开发环境下的启动服务器类
 * 
 * @author xwb
 * @since 2016年1月13日
 */
public class Test {
	public static void main(String[] args) throws IOException {
		char c = 16;
		byte b1 = 16;
		char c2 = 18;
		byte b2 = 18;
		// String cstr=new String([b1],"gbk");
		long startTime = System.currentTimeMillis();
		// FileReader fileReader = new
		// FileReader("c:\\temp\\c_SubjectEntry_2.txt","gbk");
		//
		// fileReader.readString().replaceAll(String.valueOf(c2), "\n");
		//
		// System.out.println("hutool:"+(System.currentTimeMillis()-startTime));
		// // String str = null;
		// startTime= System.currentTimeMillis();
		FileInputStream fileInputStream = new FileInputStream("c:\\temp\\c_AccPkgSubject_2.txt");
		BufferedWriter bw = null;
		File outFile = new File("c:\\temp\\c_AccPkgSubject_2_uft8.txt");
		if (!outFile.exists()) {
			outFile.createNewFile();
		}
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, "gbk"));
		String line = null;
		while ((line = br.readLine()) != null) {
			line=line.replaceAll(String.valueOf(c2), "\n");
			bw.write(line);
			bw.flush();
		}
		bw.close();
		br.close();
		System.out.println("jdk:" + (System.currentTimeMillis() - startTime));

		// <field><name>AccPackageID</name></field>
		// <field><name>SubjectID</name></field>
		// <field><name>ParentSubjectId</name></field>
		// <field><name>SubjectName</name></field>
		// <field><name>SubjectFullName</name></field>
		// <field><name>AssistCode</name></field>
		// <field><name>UomUnit</name></field>
		// <field><name>Currency</name></field>
		// <field><name>IsLeaf</name></field>
		// <field><name>Level</name></field>
		// <field><name>Property</name></field>

	}

}
