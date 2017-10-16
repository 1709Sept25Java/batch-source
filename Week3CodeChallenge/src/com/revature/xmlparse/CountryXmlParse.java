package com.revature.xmlparse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.revature.country.Country;

public class CountryXmlParse {
	
	private static String filename = "capitols.xml";

	public static List<Country> readCountries(){
		List<Country> countries = new ArrayList<>();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		
		try {
			db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(filename);
			doc.getDocumentElement().normalize();
			
			NodeList countryList = doc.getElementsByTagName("country");
			for(int i=0;i<countryList.getLength();i++) {
				Country c = new Country();
				Node country = countryList.item(i);
				
				NodeList child = country.getChildNodes();
				for(int j=0;j<child.getLength();j++) {
					Node elem = child.item(j);
					if(elem.getNodeName().equals("country")) {
						c.setName(elem.getTextContent());
					} else if(elem.getNodeName().equals("capitol")) {
						c.setCapitol(elem.getTextContent());
					}
				}
				
				countries.add(c);
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return countries;
	}
	
}
