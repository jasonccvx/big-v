//第一次载入时默认近一年
function loadDataPR(option) {

    option.xAxis.data = [];

    //初始化series[0]的data
    option.series[0].data = [];

    option.series[1].data = [];


}

var myChartProfitRate = echarts.init(document.getElementById('myLineDiv-profitRate'));
var option2 = {
    title: {
        text: '收益率折线图'
    },
    tooltip: {
        show: true,
        trigger: 'axis'
    },
    legend: {
        data: ["涨幅", "参考标的"]
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name: '涨幅',
            type: 'line'

        },
        {
            name: '参考标的',
            type: 'line'

        }
    ]
};
loadDataPR(option2);  //加载数据到option2
myChartProfitRate.setOption(option2);  //设置option2
//loadData2函数
function loadDataProfitRate(option) {
    $.ajax({
        type: "post",                         //跳转方式为post
        //async:true,                         //异步传输
        url: 'profitRateEchartsServlet',      //跳转的界面，这里必须和web.xml中的url-pattern相同。跳转到该servlet之后，获取到JSONArray类型的数据，可以被Echarts识别。
        dataType: 'json',
        data: $('#loginForm').serialize(), //aForm是form表单的id,将form中的数据提交
        success: function (result) {
            if (result) {
                option.xAxis.data = [];
                for (var i = 0; i < result.length; i++) {
                    option.xAxis.data.push(result[i].time);  //设置横坐标的数据
                }

                //初始化series[0]的data
                option.series[0].data = [];
                for (var i = 0; i < result.length; i++) {
                    option.series[0].data.push(result[i].realIncrease);   //设置纵坐标的数据
                }
                option.series[1].data = [];
                for (var i = 0; i < result.length; i++) {
                    option.series[1].data.push(result[i].referIncrease);   //设置纵坐标的数据
                }
            }
        },
        error: function (errorMsg) {
            //alert("profit1加载失败，重试");
            loadDataProfitRate(option)
        }


    });
}

