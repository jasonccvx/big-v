//第一次载入时默认近一年
function loadDataNavInit(option) {

    option.xAxis.data = [];
    //option.xAxis.data.push(0);
    //初始化series[0]的data
    option.series[0].data = [];
    //option.series[0].data.push(0);
    option.series[1].data = [];
    //option.series[1].data.push(0);


}

var myChartNav = echarts.init(document.getElementById('myLineDiv-nav'));
var option3 = {
    title: {
        text: '单位净值折线图'
    },
    tooltip: {
        show: true,
        trigger: 'axis'
    },
    legend: {
        data: ["单位净值", "日涨幅"]
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name: '单位净值',
            type: 'line'

        },
        {
            name: '日涨幅',
            type: 'line'

        }
    ]
};
loadDataNavInit(option3);  //加载数据到option3
myChartNav.setOption(option3);  //设置option3
//loadData2函数
function loadDataNav(option) {
    $.ajax({
        type: "post",                         //跳转方式为post
        //async:true,                         //异步传输
        url: 'navEchartsServlet',      //跳转的界面，这里必须和web.xml中的url-pattern相同。跳转到该servlet之后，获取到JSONArray类型的数据，可以被Echarts识别。
        dataType: 'json',
        data: $('#loginForm').serialize(), //aForm是form表单的id,将form中的数据提交
        success: function (result) {
            if (result) {
                option.xAxis.data = [];
                for (var i = 0; i < result.length; i++) {
                    //console.log(result[i].time);
                    option.xAxis.data.push(result[i].time);  //设置横坐标的数据
                }

                //初始化series[0]的data
                option.series[0].data = [];
                for (var i = 0; i < result.length; i++) {
                    //console.log(result[i].nav)
                    option.series[0].data.push(result[i].nav);   //设置纵坐标的数据
                }
                option.series[1].data = [];
                for (var i = 0; i < result.length; i++) {
                    //console.log(result[i].dailyIncrease)
                    option.series[1].data.push(result[i].dailyIncrease);   //设置纵坐标的数据
                }
            }
        },
        error: function (errorMsg) {
            /*alert("NAV加载失败，重试");*/
            loadDataNav(option)
        }


    });
}

