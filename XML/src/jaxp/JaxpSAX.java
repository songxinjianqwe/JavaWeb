package jaxp;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class JaxpSAX {
	public static void traverse() throws ParserConfigurationException, SAXException, IOException{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse("src/jaxp/person.xml", new MyNameHandler());
		
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		traverse();
	}
}
