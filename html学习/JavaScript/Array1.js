/**
 * Created by songx on 2017/1/13.
 */

var arr1 = [1,2,3];
var arr2 = [4,5,6];
document.write(arr1.length);
document.write("<br>")

document.write(arr1.concat(arr2));
document.write("<br>")

var arr3 = ["a","b","c"];
document.write(arr3.join("|"));
document.write("<br>")

var arr4 = ["1","2","3","4"];
arr4.push("5");
document.write(arr4);
document.write("<br>")


var arr5 = ["a","b","c"];
var arr6 = ["d","e","f"];
document.write(arr5.push(arr6));
document.write("<br>")
document.write(arr5);
document.write("<br>")

for(var i = 0; i < arr5.length;++i){
    alert(arr5[i]);
}






