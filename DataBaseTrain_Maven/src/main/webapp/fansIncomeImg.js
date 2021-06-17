var myChartFI = echarts.init(document.getElementById("box2"));
/*
只需要在yE中按格式导入数据
*/
var yE = [
  /*平均年化收益金额
  先在收益金额表中选出最新一天的表项 与组合表自然连接
  再与大v表自然连接 按大v名字“group by” 再select 粉丝数量，avg(收益金额)
  格式
  [粉丝数量1, 平均年化收益金额1],
  [粉丝数量2, 平均年化收益金额2],
  ......
  [粉丝数量n, 平均年化收益金额n],
  */
];
// ********以下部分暂时不用动*********
var yearlyEarning = ecStat.regression('linear', yE);
var optionFI = {
  dataset: [{source: yE}],
  title: {
    text: '<平均年化收益金额-粉丝数量>散点图',
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
    name: '平均年化收益金额',
    type: 'scatter'
  },{
    name:'年化收益金额回归分析',
    label:{position:"top",formatter:' {c}',fontSize:16},
    data:[],
    type:'line',
    smooth:true
  }
  ]
};
loadDataFI();
myChartFI.setOption(optionFI);

function loadDataFI() {
  $.ajax({
    type: "post",                         //跳转方式为post
    //async:true,                         //异步传输
    url: 'FIServlet',      //跳转的界面，这里必须和web.xml中的url-pattern相同。跳转到该servlet之后，获取到JSONArray类型的数据，可以被Echarts识别。
    dataType: 'json',
    success: function (result) {
      if (result) {
        for (var i = 0; i < result.length; i++) {
          yE.push([result[i].fansNUM,result[i].income]);
        }
      }
      yearlyEarning = ecStat.regression('polynomial', yE,3);
      yearlyEarning.points.sort(function (a,b) {
        return a[0]-b[0];
      })
      optionFI.series[1].data=yearlyEarning.points;
      myChartFI.setOption(optionFI);
    },
    error: function (errorMsg) {
     // alert("box加载失败，重试");
      /*loadDataBox();*/
    }


  });

}
