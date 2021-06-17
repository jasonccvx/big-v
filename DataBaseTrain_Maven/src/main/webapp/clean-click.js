var clean= document.getElementById("clean-btn");
clean.onclick=function() {
    //清空图表
    loadDataNavInit(option3);  //加载数据到option3
    myChartNav.setOption(option3);  //设置option3

    loadData(option);  //加载数据到option
    myChart.setOption(option);  //设置option

    loadDataPR(option2);  //加载数据到option2
    myChartProfitRate.setOption(option2);  //设置option2

    //组合的点击次数
    clickTimes=1;
    clickTimes2=1;

    document.getElementById("text").value = 1;

    //复原月份为默认近1年
    for (var i = 0; i < lis.length; i++) {
        lis[i].className = '';
    }
    lis[3].className = 'current';

    //组合点击处全部清空
    var vtable = document.getElementById("comBinArray");
    var x = vtable.getElementsByTagName('a');
    for (var i = 0; i < x.length; i++) {
        x[i].className = '';
    }

    var length=combinArray.length;
    for(var i=0;i<length;i++){
        combinArray.pop();
    }
    document.getElementById("binv").value = "";




}
function cleanFun() {
    //清空图表
    loadDataNavInit(option3);  //加载数据到option3
    myChartNav.setOption(option3);  //设置option3

    loadData(option);  //加载数据到option
    myChart.setOption(option);  //设置option

    loadDataPR(option2);  //加载数据到option2
    myChartProfitRate.setOption(option2);  //设置option2

    //组合的点击次数
    clickTimes=1;
    clickTimes2=1;

    document.getElementById("text").value = 1;

    //复原月份为默认近1年
    for (var i = 0; i < lis.length; i++) {
        lis[i].className = '';
    }
    lis[3].className = 'current';

    //组合点击处全部清空
    var vtable = document.getElementById("comBinArray");
    var x = vtable.getElementsByTagName('a');
    for (var i = 0; i < x.length; i++) {
        x[i].className = '';
    }

    var length=combinArray.length;
    for(var i=0;i<length;i++){
        combinArray.pop();
    }

    document.getElementById("binv").value = "";


}