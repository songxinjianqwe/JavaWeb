/**
 * Created by songx on 2017/1/14.
 */

setInterval("showTime()",1000);
function showTime(){
    var date = new Date();
    var div = document.getElementById("div1");
    div.innerHTML = date.toLocaleString();
}