package jaxp;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class JaxpDOM {
	public static Node getNode(String xmlURL,String tagName,int index) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlURL);
		NodeList list = doc.getElementsByTagName(tagName);
		return list.item(index);
	}
	
	
	public static void addNode(String xmlURL,String parentTag,int index,String tagName,String content) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlURL);
		Node parent = doc.getElementsByTagName(parentTag).item(index);
		Element child = doc.createElement(tagName);
		Text text  = doc.createTextNode(content);
		child.appendChild(text);
		parent.appendChild(child);
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		transformer.transform(new DOMSource(doc), new StreamResult(xmlURL));
	}
	
	public static String updateNode(String xmlURL,String tagName,int index,String newContent) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlURL);
		Node node = doc.getElementsByTagName(tagName).item(index);
		String oldContent = node.getTextContent();
		node.setTextContent(newContent);
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		transformer.transform(new DOMSource(doc), new StreamResult(xmlURL));
		return oldContent;
	}
	
	public static String deleteNode(String xmlURL,String tagName,int index) throws ParserConfigurationException, SAXException, IOException, TransformerException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlURL);
		Node child = doc.getElementsByTagName(tagName).item(index);
		String content = child.getTextContent();
		child.getParentNode().removeChild(child);
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		transformer.transform(new DOMSource(doc), new StreamResult(xmlURL));
		return content;
	}
	
	public static void traverseNode(Node node){
		if(node.getNodeType() == Node.ELEMENT_NODE){
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for(int i = 0; i < list.getLength();++i){
			traverseNode(list.item(i));
		}
	}
	
	public static void traverseXML(String xmlURL) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlURL);
		traverseNode(doc);
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
//		Node node = getNode("src/jaxp/person.xml","name",0);
//		System.out.println(node.getTextContent());
//		addNode("src/jaxp/person.xml","p1",0,"sex","male");
//		updateNode("src/jaxp/person.xml","sex",0,"female");
//		deleteNode("src/jaxp/person.xml","sex",0);
		traverseXML("src/jaxp/person.xml");
		
		
	}
	
	
}
