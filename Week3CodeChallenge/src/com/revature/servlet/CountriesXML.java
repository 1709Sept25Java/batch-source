
package com.revature.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class CountriesXML {
	
	private String docLocation = "src/Countries.xml";
	public CountriesXML() {
		super();
	}
	
	public ArrayList<Country> readCountriesDOM() {
		ArrayList<Country> countries = new ArrayList<Country>();
		String filename = this.docLocation;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		
		try {
			db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(filename);
			doc.getDocumentElement().normalize();
			NodeList countriesList = doc.getElementsByTagName("country");
			
			for (int i=0; i<countriesList.getLength(); i++) {
				Node country = countriesList.item(i);
				Country newCountry = new Country();
				newCountry.setName(country.getAttributes().item(0).getNodeValue());
				newCountry.setCapital(country.getAttributes().item(1).getNodeValue());
				countries.add(newCountry);		
			}	

		} catch (Exception e) {
			e.printStackTrace();
		}
		return countries;
	}
	
	
	

}
