/**
 * Created by songx on 2017/1/14.
 */
var js = ["南京","苏州","宿迁","无锡"];
var sd = ["济南","烟台","蓬莱","日照"];
var zj = ["杭州","宁波"];

function selectCity(province){
    var target = document.getElementById("city");
    var citys = target.getElementsByTagName("option");
    for(var i = 0; i < citys.length;++i){
        target.removeChild(citys[i]);
        i--;
    }
    
    switch(province){
        case "js":
            for(var i = 0; i < js.length;++i){
                var city = document.createElement("option");
                var text = document.createTextNode(js[i]);
                city.appendChild(text);
                target.appendChild(city);
            }
            break;
        case  "sd":
            for(var i = 0; i < sd.length;++i){
                var city = document.createElement("option");
                var text = document.createTextNode(sd[i]);
                city.appendChild(text);
                target.appendChild(city);
            }
            break;
        case "zj":
            for(var i = 0; i < zj.length;++i){
                var city = document.createElement("option");
                var text = document.createTextNode(zj[i]);
                city.appendChild(text);
                target.appendChild(city);
            }
            break;
    }
}