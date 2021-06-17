function loadData(option) {
    option.xAxis[0].data = [];


    //初始化series[0]的data
    for (var i = 0; i < clickTimes; i++) {
        option.series[i].data = [];
        option.series[i].name = "";
    }

}

var myChart = echarts.init(document.getElementById('myLineDiv'));
var option = {
    title: {
        text: '收益金额折线图'
    },
    tooltip: {
        show: true,
        trigger: 'axis'
    },
    legend: {
        /*data: ['收益金额']*/
    },
    xAxis: [{
        type: 'category'
    }],
    yAxis: [{
        type: 'value'
    }],
    series: [{
        name: '收益金额',
        type: 'line'

    },
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'},
        {type: 'line'}

    ]
};
loadData(option);  //加载数据到option
myChart.setOption(option);  //设置option
//判断函数
//loadData2函数
function loadData2(option) {
    $.ajax({
        type: "post",                         //跳转方式为post
        //async:true,                         //异步传输
        url: 'profitEcharsServlet',
        data: $('#loginForm').serialize(), //aForm是form表单的id,将form中的数据提交
        dataType: 'json',
        success: function (result) {
            var isExist = 1;

            function ifExist() {
                for (var i = 0; i < combinArray.length - 1; i++) {
                    if (result[0].comName == combinArray[i]) {
                        isExist = 0;
                    }

                }
                if (option.series[clickTimes - 2].name == combinArray[combinArray.length - 1] + " :收益金额") {
                    isExist = 0;
                }
            }

            ifExist();
            if (isExist) {
                if (result) {
                    option.xAxis[0].data = [];
                    for (var i = 0; i < result.length; i++) {
                        option.xAxis[0].data.push(result[i].time);  //设置横坐标的数据
                    }

                    //初始化series[0]的data
                    option.series[clickTimes - 1].data = [];
                    option.series[clickTimes - 1].name = result[0].comName + " :收益金额";
                    for (var i = 0; i < result.length; i++) {
                        option.series[clickTimes - 1].data.push(result[i].income);   //设置纵坐标的数据
                    }
                }
            } else {
                clickTimes--;
            }
        },
        error: function (errorMsg) {
            //alert("profit2加载失败，重试");
/*            loadData2(option)*/
        }
    });
}

function loadData3(option) {
    $.ajax({
        type: "post",                         //跳转方式为post
        //async:true,                         //异步传输
        url: 'profitEcharsServlet',
        data: $('#loginForm').serialize(), //aForm是form表单的id,将form中的数据提交
        dataType: 'json',
        success: function (result) {
            if (result) {
                option.xAxis[0].data = [];
                for (var i = 0; i < result.length; i++) {
                    option.xAxis[0].data.push(result[i].time);  //设置横坐标的数据
                }
                //初始化series[0]的data
                option.series[clickTimes - 1].data = [];
                option.series[clickTimes - 1].name = result[0].comName + " :收益金额";
                for (var i = 0; i < result.length; i++) {
                    option.series[clickTimes - 1].data.push(result[i].income);   //设置纵坐标的数据
                }
            }
            clickTimes++;
            myChart.setOption(option);

        },
        error: function (errorMsg) {
/*            loadData3(option)*/
        }
    });
}

function loadData4(option) {
    $.ajax({
        type: "post",                         //跳转方式为post
        //async:true,                         //异步传输
        url: 'profitEcharsServlet',
        data: $('#loginForm').serialize(), //aForm是form表单的id,将form中的数据提交
        dataType: 'json',
        success: function (result) {
            if (result) {
                option.xAxis[0].data = [];
                for (var i = 0; i < result.length; i++) {
                    option.xAxis[0].data.push(result[i].time);  //设置横坐标的数据
                }

                //初始化series[0]的data
                option.series[0].data = [];
                option.series[0].name = result[0].comName + " :收益金额";
                for (var i = 0; i < result.length; i++) {
                    option.series[0].data.push(result[i].income);   //设置纵坐标的数据
                }
            }
            myChart.setOption(option);

        },
        error: function (errorMsg) {
        }
    });
}

