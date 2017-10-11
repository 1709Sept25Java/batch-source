package com.revature.io;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BearHandler extends DefaultHandler{

	public BearHandler() {
		super();
	}
	
	//what to do at start of an element
	@Override
	public void startElement(String url, String localname,String qName,Attributes attributes) throws SAXException {
		System.out.println(qName+": ");
		System.out.println("attributes: "+attributes.toString());
	}
	
	
	//what to do at end of an element
	@Override
	public void endElement(String url,String localname,String qName) throws SAXException {
		System.out.println("// "+qName);
	}
	
	
	//what to do when we encounter element contents
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		System.out.println(new String(ch,start,length));
	}
}
