/**
 * Created by songx on 2017/1/13.
 */
document.write("<table border='1' border-color='red'> ")
for(var i = 1;i <= 9; ++i){
    document.write("<tr>")
    for(var j = 1 ; j <= i;++j){
       document.write("<td>"+j+"*"+i+"="+j*i+"</td>");
    }
    document.write("</tr>");
}
document.write("</table>")
