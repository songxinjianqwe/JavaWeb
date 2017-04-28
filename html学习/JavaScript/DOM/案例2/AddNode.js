/**
 * Created by songx on 2017/1/14.
 */

function addNode(){
    var ul = document.getElementById("ul");
    var newLi = document.createElement("li");
    var newText = document.createTextNode("4");
    newLi.appendChild(newText);
    ul.appendChild(newLi);
}
