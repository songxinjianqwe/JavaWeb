/**
 * Created by songx on 2017/1/14.
 */

var span = document.getElementById("sp");
document.write("<br><br>");
document.write(span.nodeName+"<br>");
document.write(span.nodeType+"<br>");
document.write(span.nodeValue+"<br>");
document.write("<br>");

var idNode = span.getAttributeNode("id");
document.write(idNode.nodeName+"<br>");
document.write(idNode.nodeType+"<br>");
document.write(idNode.nodeValue+"<br>");
document.write("<br>");

var textNode = span.firstChild;
document.write(textNode.nodeName+"<br>");
document.write(textNode.nodeType+"<br>");
document.write(textNode.nodeValue+"<br>");
document.write("<br>");






