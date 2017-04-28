/**
 * Created by songx on 2017/1/14.
 */

function generate() {
    var row = parseInt(document.getElementById("row").value);
    var col = parseInt(document.getElementById("col").value);
    var table  = "<table border='2' bordercolor='red'>";
    for (var i = 0; i < row; ++i) {
        table += "<tr>"
        for (var j = 0; j < col; ++j) {
            table += "<td>呵呵</td>"
        }
        table += "</tr>";
    }
    table += "</table>";

    var tab = document.getElementById("table");
    tab.innerHTML = table;
}
