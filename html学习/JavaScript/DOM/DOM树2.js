/**
 * Created by songx on 2017/1/14.
 */

function addBefore(){
    var ul = document.getElementById("ul");
    var li2 = document.getElementById("li2");
    
    var li3 = document.createElement("li");
    var text3 = document.createTextNode("啵啵");
    li3.appendChild(text3);
    
    ul.insertBefore(li3,li2);
}

