package com.revature.dao;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.revature.domain.Bear;

public class BearDaoXMLImpl implements BearDao{
	
	private String docLocation;
	public BearDaoXMLImpl() {
		super();
	}
	public BearDaoXMLImpl(String docLocation) {
		this();
		this.docLocation = docLocation;
	}

	@Override
	public List<Bear> getBears() {
		
		return null;
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int feedBear(int bearId, int hiveId, int amt) {
		return 0;
	}
	@Override
	public int createBear(Bear bear) {
		return 0;
	}
	public void readBearsSax(String filename) {
		SAXParserFactory factory = SAXParserFactory. newInstance();
		try {
			SAXParser sp = factory.newSAXParser(); //this is a good candidate for a singleton 
												  // or singleton factory 
			sp.parser(filename, handler);
		}catch() {
			
		}
	}

}
