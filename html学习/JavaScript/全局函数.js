/**
 * Created by songx on 2017/1/13.
 */

var code = "alert('abc')";
eval(code);

var str = "宋欣建sxj";
var encode = encodeURI(str);
document.write(encode);
document.write("<br>");
var decode = decodeURI(encode);
document.write(decode);
document.write("<br>");


var str2 = "123";
document.write(str2+1);
document.write("<br>");
document.write(parseInt(str2)+1);



