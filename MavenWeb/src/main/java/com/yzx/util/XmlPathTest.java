package com.yzx.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.dom.DOMElement;
public class XmlPathTest {

	public static void main(String[] args) throws DocumentException, IOException {
		SAXReader reader = new SAXReader();
//		String str = new String("");
//		
//		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("utf-8"));
//		Document doc = reader.read("F:\\ajax\\1.xml");	 
//		List<Element> list = doc.selectNodes("//from");
//		for(Element el:list)
//		{
//			System.out.println(el.getText());
//			
//			
//		}
//		Element n = (Element) doc.selectSingleNode("//from[@name='guoxiaoyang']");
//		
//		System.out.println(n.getName());
//		System.out.println(n.asXML());
//		System.out.println(n.getPath());
//		
//		System.out.println(n.getText());
//		System.out.println(n.attributeValue("name").trim());
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		XMLWriter writer = new XMLWriter(bos);
		
		Element el = new DOMElement("hello");
		
		
		el.setText("123");
		writer.write(el);

		
		System.out.println(new String(bos.toByteArray()));
		writer.close();
		bos.close();
		
	}

}
