/**
 * Created by songx on 2017/1/14.
 */


function selectAll(){
    var checkboxs = document.getElementsByName("sports");
    for(var i = 0; i < checkboxs.length;++i){
        checkboxs[i].checked = true;
    }
}

function selectNone(){
    var checkboxs = document.getElementsByName("sports");
    for(var i = 0; i < checkboxs.length;++i){
        checkboxs[i].checked = false;
    }
}

function reverseSelect(){
    var checkboxs = document.getElementsByName("sports");
    for(var i = 0; i < checkboxs.length;++i) {
        checkboxs[i].checked = !checkboxs[i].checked;
    }
}

function selectAllOrNone(){
    var checkboxs = document.getElementsByName("sports");
    if(document.getElementById("cb").checked){
        selectAll();
    }else{
        selectNone();
    }
}


