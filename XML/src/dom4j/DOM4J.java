package dom4j;


import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class DOM4J {
	public static void findByTag(String parentTag,String tagName) throws DocumentException{
		Document doc = Dom4JUtils.getDocument(Dom4JUtils.DEFAULT_PATH);
		Element root = doc.getRootElement();
		List<Element> p1s = root.elements(parentTag);
		for(Element p1:p1s){
			Element name = p1.element(tagName);
			System.out.println(name.getText());
		}
	}
	
	public static void findByTagWithXPATH(String tagName) throws DocumentException{
		Document doc = Dom4JUtils.getDocument(Dom4JUtils.DEFAULT_PATH);
		List<Node> list = doc.selectNodes("//"+tagName);
		for(Node node:list){
			System.out.println(node.getText());
		}
	}
	
	
	public static void findByTagAndIndex(String parentTag,int index,String tagName) throws DocumentException{
		Document doc = Dom4JUtils.getDocument(Dom4JUtils.DEFAULT_PATH);
		Element root = doc.getRootElement();
		Element p1 = (Element) root.elements(parentTag).get(index);
		Element target = p1.element(tagName);
		System.out.println(target.getText());
	}
	
	public static void findByTagAndIndexWithXPATH(String parentTag,int index,String tagName) throws DocumentException{
		Document doc = Dom4JUtils.getDocument(Dom4JUtils.DEFAULT_PATH);
		Node node = doc.selectSingleNode("//"+parentTag+"[@id='"+index+"']/"+tagName);
		System.out.println(node.getText());
	}
	
	
	public static void addTag(String parentTag,int index ,String tagName,String content) throws DocumentException, IOException{
		Document doc = Dom4JUtils.getDocument(Dom4JUtils.DEFAULT_PATH);
		Element root = doc.getRootElement();
		Element parent = (Element) root.elements(parentTag).get(index);
		Element child = parent.addElement(tagName);
		child.setText(content);
		Dom4JUtils.writeBack(Dom4JUtils.DEFAULT_PATH, doc);
	}
	
	public static void addTagBeforeTag(String parentTag,int index,String origTagName,String newTagName,String content) throws DocumentException, IOException{
		Document doc = Dom4JUtils.getDocument(Dom4JUtils.DEFAULT_PATH);
		Element root = doc.getRootElement();
		Element parent = (Element) root.elements(parentTag).get(index);
		List<Element> childs = parent.elements();
		
		Element newTag = DocumentHelper.createElement(newTagName);
		newTag.setText(content);
		
		for(int i = 0; i < childs.size() ;++i){
			if(childs.get(i).getName().equals(origTagName)){
				childs.add(i,newTag );
				break;
			}
		}
		Dom4JUtils.writeBack(Dom4JUtils.DEFAULT_PATH, doc);
	}
	
	
	public static String updateTag(String parentTag,int index, String tagName,String newContent){
		Document doc = Dom4JUtils.getDocument(Dom4JUtils.DEFAULT_PATH);
		Element  root = doc.getRootElement();
		Element parent = (Element) root.elements(parentTag).get(index);
		Element target = parent.element(tagName);
		String oldContent = target.getText();
		target.setText(newContent);
		Dom4JUtils.writeBack(Dom4JUtils.DEFAULT_PATH, doc);
		return oldContent;
	} 
	
	public static String removeTag(String parentTag,int index,String tagName){
		Document doc = Dom4JUtils.getDocument(Dom4JUtils.DEFAULT_PATH);
		Element root = doc.getRootElement();
		Element parent = (Element) root.elements(parentTag).get(index);
		Element child = parent.element(tagName);
		String content = child.getText();
		parent.remove(child);
		Dom4JUtils.writeBack(Dom4JUtils.DEFAULT_PATH, doc);
		return content;
	}
	
	public static String getAttribute(String parentTag,int index,String attributeName){
		Document doc = Dom4JUtils.getDocument(Dom4JUtils.DEFAULT_PATH);
		Element root = doc.getRootElement();
		Element parent = (Element) root.elements(parentTag).get(index);
		return parent.attributeValue(attributeName);
	}
	
	
	
	public static void main(String[] args) throws DocumentException, IOException {
//		findByTagAndIndex("p1", 0,"name");
//		addTagBeforeTag("p1", 0, "age", "school", "NJU");
//		updateTag("p1",0,"age","30");
//		removeTag("p1",0,"school");
//		System.out.println(getAttribute("p1", 0, "id"));
//		findByTagWithXPATH("name");
		findByTagAndIndexWithXPATH("p1",1,"name");
	}
}
