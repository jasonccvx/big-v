function showBigV() {
    $.ajax({
        url: 'bigVListServlet',
        type: 'POST',
        dataType: 'json',
        success: function (result) {
            var str = "";
            str += "<table id=bigvTable class=\"bigvtable\" style='font-size: 10px; text-decoration: none'>";
            str+="<tr><th style='height: 30px; font-size: 15px'>大V名</th><th style='height: 30px; font-size: 15px'>粉丝数</th><tr>"
            if (result) {
                for (var i = 0; i < result.length; i++) {
                    str +="<tr>";
                    str += " <td style='height: 30px; width: 50%;text-align: center; transition: all .14s linear;'><a href=\"#\" style='text-decoration: none; color: #345; font-weight: bold' id="+result[i].name+ ">"+ result[i].name + "</a></td>";
                    str += " <td style='height: 30px; width: 50%;text-align: center; transition: all .14s linear;'>" + result[i].fansNUM + "</td>";
                    str += "</tr>";
                }
            }
            str += "</table>";
            document.getElementById('bigvArray').innerHTML = str;
            //注意，这里天坑，自动增加的元素必须用这种方法点击,函数放在这个位置！！！
            var vtable = document.getElementById("bigvArray");
            var x = vtable.getElementsByTagName('a');
            for (var i = 0; i < x.length; i++) {
                x[i].onclick = function () {
                    for (var i = 0; i < x.length; i++) {
                        x[i].className = '';
                    }
                    // this.className = 'current';
                    // console.log(this.getAttribute('id'));
                    // vID = this.getAttribute('id');
                    // document.getElementById("binv").value = vID;
                }
            }
        },
        error: function (errorMsg) {
            //alert("大V数据加载失败，重试");
            showBigV();
        }
    })
}
showBigV();

