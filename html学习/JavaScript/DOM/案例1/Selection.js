/**
 * Created by songx on 2017/1/14.
 */
function fill(id,name){
    var pWindow = window.opener;
    pWindow.document.getElementById("id").value = id;
    pWindow.document.getElementById("name").value = name;
    window.close();
}
