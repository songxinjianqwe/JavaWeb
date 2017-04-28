package jaxp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyNameHandler extends DefaultHandler{
	private boolean isName = false;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("name")){
			isName = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		isName = false;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(isName){
			System.out.println(new String(ch,start,length));
		}
	}
}
