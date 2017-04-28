/**
 * Created by songx on 2017/1/13.
 */
var param = "a,b";
var body = "var sum = a + b;"+
    "return sum;";
var add = new Function(param,body);
alert(add(3,4));

