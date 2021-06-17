var myChartBox = echarts.init(document.getElementById("box"));
/*
只需要在mD、sR、v、eR中按格式导入数据
如果点击“近一个月”,则对应指标导入“近一个月”对应数据
“近三个月”、“近半年”、“近一年”以此类推
*/
var mD = [
    /*最大回撤
    格式

    [组合市值1, 最大回撤1],
    [组合市值2, 最大回撤2],
    ......
    [组合市值n, 最大回撤n]
    */
];
var sR = [
    /*夏普比率
    格式
    [组合市值1, 夏普比率1],
    [组合市值2, 夏普比率2],
    ......
    [组合市值n, 夏普比率n]
    */
];
var v = [
    /*波动率
    格式
    [组合市值1, 波动率1],
    [组合市值2, 波动率2],
    ......
    [组合市值n, 波动率n]
    */
];

// ********以下部分暂时不用动*********
/*var maxDrawdown = ecStat.regression('linear', mD);
var sharpeRatio = ecStat.regression('linear', sR);
var volatility = ecStat.regression('linear', v);*/
var maxDrawdown = ecStat.regression('linear', mD);
var sharpeRatio = ecStat.regression('linear', sR);
var volatility = ecStat.regression('linear', v);
var optionBox = {
    dataset: [{source: mD}, {source: sR}, {source: v}],
    title: {
        text: '<指标-市值>散点图',
        left: 'center'
    },
    legend: {
        bottom: 5
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        }
    },
    xAxis: {
        splitLine: {
            lineStyle: {
                type: 'dashed'
            }
        },
    },
    yAxis: {
        splitLine: {
            lineStyle: {
                type: 'dashed'
            }
        },
    },
    series: [{
        name: '最大回撤',
        type: 'scatter',
        datasetIndex: 0
    }, {
        name: '夏普比率',
        type: 'scatter',
        datasetIndex: 1
    }, {
        name: '波动率',
        type: 'scatter',
        datasetIndex: 2
    },{
        name:'最大回撤回归分析',
        label:{position:"top",formatter:' {c}',fontSize:16},
        data:[],
        type:'line',
        smooth:true
    },{
        name:'夏普比率回归分析',
        label:{position:"top",formatter:' {c}',fontSize:16},
        data:[],
        type:'line',
        smooth:true
    },{
        name:'波动率回归分析',
        label:{position:"top",formatter:' {c}',fontSize:16},
        data:[],
        type:'line',
        smooth:true
    }
    ]
};
loadDataBox();
//loadDataBoxSR();
myChartBox.setOption(optionBox);
function loadDataBox() {
    $.ajax({
        type: "post",                         //跳转方式为post
        //async:true,                         //异步传输
        url: 'boxEcharsServlet',      //跳转的界面，这里必须和web.xml中的url-pattern相同。跳转到该servlet之后，获取到JSONArray类型的数据，可以被Echarts识别。
        dataType: 'json',
        data: $('#loginForm').serialize(), //aForm是form表单的id,将form中的数据提交
        success: function (result) {
            if (result) {
                for (var i = 0; i < result.length; i++) {
                    mD.push([result[i].newMarketValue, result[i].maxRec]);
                }
                /* for (var i = 0; i < result.length; i++) {
                     mD.push([result[i].newMarketValue,result[i].sharpeRatio]);
                 }*/
            }
            maxDrawdown = ecStat.regression('polynomial', mD,3);
            maxDrawdown.points.sort(function (a,b) {
                return a[0]-b[0];
            })
            optionBox.series[3].data=maxDrawdown.points;
            myChartBox.setOption(optionBox);
        },
        error: function (errorMsg) {
            //alert("box加载失败，重试");
            /*loadDataBox();*/
        }


    });

    $.ajax({
        type: "post",                         //跳转方式为post
        //async:true,                         //异步传输
        url: 'sRServlet',      //跳转的界面，这里必须和web.xml中的url-pattern相同。跳转到该servlet之后，获取到JSONArray类型的数据，可以被Echarts识别。
        dataType: 'json',
        data: $('#loginForm').serialize(), //aForm是form表单的id,将form中的数据提交
        success: function (result) {
            if (result) {
                for (var i = 0; i < result.length; i++) {
                    sR.push([result[i].newMarketValue, result[i].sharpeRatio]);
                }
                /* for (var i = 0; i < result.length; i++) {
                     mD.push([result[i].newMarketValue,result[i].sharpeRatio]);
                 }*/
            }
            sharpeRatio = ecStat.regression('polynomial', sR,3);
            sharpeRatio.points.sort(function (a,b) {
                return a[0]-b[0];
            })
            optionBox.series[4].data=sharpeRatio.points;
            myChartBox.setOption(optionBox);
        },
        error: function (errorMsg) {
            //alert("box加载失败，重试");
            /*loadDataBox();*/
        }


    });
    $.ajax({
        type: "post",                         //跳转方式为post
        //async:true,                         //异步传输
        url: 'volServlet',      //跳转的界面，这里必须和web.xml中的url-pattern相同。跳转到该servlet之后，获取到JSONArray类型的数据，可以被Echarts识别。
        dataType: 'json',
        data: $('#loginForm').serialize(), //aForm是form表单的id,将form中的数据提交
        success: function (result) {
            if (result) {
                for (var i = 0; i < result.length; i++) {
                    v.push([result[i].newMarketValue, result[i].volatility]);
                }
                /* for (var i = 0; i < result.length; i++) {
                     mD.push([result[i].newMarketValue,result[i].sharpeRatio]);
                 }*/
            }

            volatility = ecStat.regression('polynomial', v,3);
            volatility.points.sort(function (a,b) {
                return a[0]-b[0];
            })
            optionBox.series[5].data=volatility.points;
            myChartBox.setOption(optionBox);
        },
        error: function (errorMsg) {
            //alert("box加载失败，重试");
            /*loadDataBox();*/
        }


    });
};

