package dom4j;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4JUtils {
	public static final String DEFAULT_PATH = "src/jaxp/person.xml";
	
	/**
	 * 返回一个Document
	 * @param xmlURL
	 * @return
	 */
	public static Document getDocument(String xmlURL){
		try{
			SAXReader reader = new SAXReader();
			return reader.read(xmlURL);
		}catch(DocumentException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 回写
	 * @param xmlURL
	 * @param document
	 */
	public static void writeBack(String xmlURL,Document document){
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileOutputStream(xmlURL),OutputFormat.createPrettyPrint());
			writer.write(document);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}	
