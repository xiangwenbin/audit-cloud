package com.zhonghui.auditcloud.webapp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.transaction.annotation.EnableTransactionManagement;





/**
 * 开发环境下的启动服务器类
 * 
 * @author xwb
 * @since 2016年1月13日
 */
public class Test  {

	public static void main(String[] args) throws IOException {
		char c = 16;
		byte b1=16;
		char c2 = 18;
		byte b2=18;
//		String cstr=new String([b1],"gbk");
//		FileReader fileReader = new FileReader("c:\\temp\\c_AccPkgSubject_2.txt","gbk");
//		
//		System.out.println(fileReader.readString().replaceAll(String.valueOf(b1), "&").replaceAll(String.valueOf(b2), "\n"));
		String str  = null;
		FileInputStream fileInputStream = new FileInputStream("c:\\temp\\test.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(fileInputStream,"gbk"));
		String line=null;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
//		<field><name>AccPackageID</name></field>
//		<field><name>SubjectID</name></field>
//		<field><name>ParentSubjectId</name></field>
//		<field><name>SubjectName</name></field>
//		<field><name>SubjectFullName</name></field>
//		<field><name>AssistCode</name></field>
//		<field><name>UomUnit</name></field>
//		<field><name>Currency</name></field>
//		<field><name>IsLeaf</name></field>
//		<field><name>Level</name></field>
//		<field><name>Property</name></field>
		
	}

	

	
}
