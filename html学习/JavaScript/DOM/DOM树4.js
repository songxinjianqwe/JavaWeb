/**
 * Created by songx on 2017/1/14.
 */

function addElements(){
    var ul = document.getElementById("ul1");
    var ul2 = ul.cloneNode(true);
    var div2 = document.getElementById("div2");
    div2.appendChild(ul2);
}

