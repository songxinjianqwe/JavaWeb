/**
 * Created by songx on 2017/1/13.
 */

/*
function ok(){
    var text = document.getElementById("text");
    alert(text.value);
}
*/
// document.getElementById("text").value = "呵呵呵";
/*var texts = document.getElementsByName("name");
document.write(texts.length);
document.write("<br>"); 
for(var i = 0; i < texts.length;++i){
    document.write(texts[i].value);
    document.write("<br>");
}*/

var texts = document.getElementsByTagName("input");
document.write(texts.length);
document.write("<br>");
for(var i = 0; i < texts.length;++i){
    document.write(texts[i].value);
    document.write("<br>");
}
