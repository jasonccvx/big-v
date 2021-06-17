new_element = document.createElement("script");
new_element.setAttribute("type", "text/javascript");
new_element.setAttribute("src", "profitImg.js");// 在这里引入了profitImg.js
document.body.appendChild(new_element);

function showCombin() {
    $.ajax({
        url: 'comListServlet',
        type: 'POST',
        dataType: 'json',
        success: function (result) {
            var str = "";
            str += "<table id=bigvTable class='combotable' style='font-size: 10px; text-decoration: none'>";
            str += "<tr><th style='height: 30px; font-size: 15px'>组合名字</th><th style='height: 30px; font-size: 15px'>大V名字</th>" +
                "<th style='height: 30px; font-size: 15px'>组合类型</th><th style='height: 30px; font-size: 15px'>成立以来年化</th>" +
                "<th style='height: 30px; font-size: 15px'>日涨幅</th><th style='height: 30px; font-size: 15px'>最新净值</th>" +
                "<th style='height: 30px; font-size: 15px'>最新市值</th><th style='height: 30px; font-size: 15px'>成立时间</th><tr>"
            if (result) {
                for (var i = 0; i < result.length; i++) {
                    str += "<tr>";
                    str += " <td style='height: 30px;width:130px'><a href=\"#\" style='text-decoration: none; color: #345; font-weight: bold' id=" + result[i].comName + ">" + result[i].comName + "</a></td>";
                    str += " <td style='height: 30px;width:130px'>" + result[i].vname + "</td>";
                    str += " <td style='height: 30px;width:100px'>" + result[i].type + "</td>";
                    str += " <td style='height: 30px;width:120px'>" + result[i].annuRate + "</td>";
                    str += " <td style='height: 30px;width:100px'>" + result[i].dayIncrease + "</td>";
                    str += " <td style='height: 30px;width:100px'>" + result[i].newNetWorth + "</td>";
                    str += " <td style='height: 30px;width:130px'>" + result[i].newMarketValue + "</td>";
                    str += " <td style='height: 30px;width:120px'>" + result[i].estabDay + "</td>";
                    str += "</tr>";
                }
            }
            str += "</table>";
            document.getElementById('comBinArray').innerHTML = str;
            //注意，这里天坑，自动增加的元素必须用这种方法点击,函数放在这个位置！！！
            var vtable = document.getElementById("comBinArray");
            var x = vtable.getElementsByTagName('a');
            for (var i = 0; i < x.length; i++) {
                x[i].onclick = function () {
                    if (ifChange == 0) {
                        for (var i = 0; i < x.length; i++) {
                            x[i].className = '';
                        }
                    }
                    this.className = 'current';
                    vID = this.getAttribute('id');

                    document.getElementById("binv").value = vID;


                    if (ifChange == 1) {
                        var ifAdd = 1;
                        for (var i = 0; i < combinArray.length; i++) {
                            if (vID == combinArray[i]) ifAdd = 0;

                        }
                        console.log("ifAdd" + ifAdd);
                        if (ifAdd) {
                            combinArray.push(vID);
                        }
                        clickTimes++;
                        //重新提交请求到profit
                        loadData2(option);
                        myChart.setOption(option);
                    }else{
                        //重新提交请求到profit
                        loadData4(option);
                        myChart.setOption(option);
                    }


                    //重新提交请求到NAV
                    loadDataNav(option3);
                    myChartNav.setOption(option3);
                    //重新提交请求到profitRate
                    loadDataProfitRate(option2);
                    myChartProfitRate.setOption(option2);


                }
            }
        },
        error: function (errorMsg) {
            //alert("组合数据加载失败，重试");
            showCombin()
        }
    })
}

showCombin();

