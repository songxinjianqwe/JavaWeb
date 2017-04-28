/**
 * Created by songx on 2017/1/14.
 */


function moveSelectedToLeft(){
    var cbbLeft = document.getElementById("leftCombobox");
    var cbbRight = document.getElementById("rightCombobox");
    var tags = cbbRight.getElementsByTagName("option");
    for(var i = 0; i < tags.length;++i){
        if(tags[i].selected){
            cbbLeft.appendChild(tags[i]);
            i--; 
        }
    }
}

function moveSelectedToRight(){
    var cbbLeft = document.getElementById("leftCombobox");
    var cbbRight = document.getElementById("rightCombobox");
    var tags = cbbLeft.getElementsByTagName("option");
    for(var i = 0; i < tags.length;++i){
        if(tags[i].selected){
            cbbRight.appendChild(tags[i]);
            i--;
        }
    }
}

function moveAllToLeft(){
    var cbbLeft = document.getElementById("leftCombobox");
    var cbbRight = document.getElementById("rightCombobox");
    var tags = cbbRight.getElementsByTagName("option");
    for(var i = 0; i < tags.length;++i){
        cbbLeft.appendChild(tags[i]);
        i--;
    }
}

function moveAllToRight(){
    var cbbLeft = document.getElementById("leftCombobox");
    var cbbRight = document.getElementById("rightCombobox");
    var tags = cbbLeft.getElementsByTagName("option");
    for(var i = 0; i < tags.length;++i){
        cbbRight.appendChild(tags[i]);
        i--;
    }
}







