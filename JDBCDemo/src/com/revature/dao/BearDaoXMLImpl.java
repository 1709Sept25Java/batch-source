package com.revature.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.revature.domain.Bear;
import com.revature.domain.BearType;
import com.revature.domain.Cave;
import com.revature.io.BearHandler;

public class BearDaoXMLImpl implements BearDao{
	
	private String docLocation;
	
	public BearDaoXMLImpl(String docLocation) {
		this.docLocation = docLocation;
	}

	@Override
	public List<Bear> getBears() {
		//readBearsSAX(this.docLocation);
		try {
			readBearsDOM(this.docLocation);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int feedBear(int bearId, int hiveId, int amt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createBear(Bear bear) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void readBearsSAX(String filename) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser sp;
			sp = factory.newSAXParser();
			BearHandler handler = new BearHandler(); //this is a good candidate for singleton
				 										 //or singleton factory
			sp.parse(filename, handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private List<Bear> readBearsDOM(String filename) throws ParseException {
		List<Bear> b1 = new ArrayList<>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		
		try {
			db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(filename);
			doc.getDocumentElement().normalize();
			
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList bearList = doc.getElementsByTagName("bear");
			for(int i=0;i<bearList.getLength();i++) {
				Bear newBear = new Bear();
				Cave newCave = new Cave();
				BearType newType = new BearType();
				Node bear = bearList.item(i);
				
				System.out.println("\t"+bear.getNodeName());
				NodeList children = bear.getChildNodes();
				for(int j=0;j<children.getLength();j++) {
					Node child = children.item(j);
					if(child.getNodeType()==Node.ELEMENT_NODE) {
						System.out.println("\t\t"+child.getNodeName()+" : "+child.getTextContent());
						if(child.getNodeName().equals("name")) {
							newBear.setName(child.getTextContent());
						}
						if(child.getNodeName().equals("weight")) {
							newBear.setWeight(Integer.parseInt(child.getTextContent()));
						}
						if(child.getNodeName().equals("birthdate")) {
							String dateString = child.getTextContent();
							DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
							Date d = (Date)formatter.parse(dateString);
							java.sql.Date sqlDate = new java.sql.Date(d.getTime());
							newBear.setBirthdate(sqlDate);
						}
						
					} else {
						System.out.println("\t\t"+child.getNodeName());
						if(child.getNodeName().equals("cave")) {
							newCave.setId(Integer.parseInt(child.getAttributes().item(0).getTextContent()));
							NodeList grandchildren = child.getChildNodes();
							for(int k=0;k<grandchildren.getLength();k++) {
								Node grandchild = grandchildren.item(k);
								if(grandchild.getNodeName().equals("name")) {
									newCave.setName(grandchild.getTextContent());
								}
								if(grandchild.getNodeName().equals("maxBears")) {
									newCave.setMaxBears(Integer.parseInt(grandchild.getTextContent()));
								}
							}
						}
						
						NodeList grandchildren = child.getChildNodes();
						for(int k=0;k<grandchildren.getLength();k++) {
							Node grandchild = grandchildren.item(k);
							if(child.getNodeType()==Node.ELEMENT_NODE) {
								System.out.println("\t\t"+grandchild.getNodeName()+" : "+grandchild.getTextContent());
							}
						}
					}
				}
				
				b1.add(newBear);
				
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return b1;
	}
	
	public Bear unmarshalBear(String filename) {
		Bear b = null;
		try {
			File file = new File(filename);
			JAXBContext jxbc = JAXBContext.newInstance(Bear.class);
			Unmarshaller jxbu = jxbc.createUnmarshaller();
			
			b = (Bear) jxbu.unmarshal(file);
		} catch(JAXBException e) {
			e.printStackTrace();
		}
		return b;
	}

}
