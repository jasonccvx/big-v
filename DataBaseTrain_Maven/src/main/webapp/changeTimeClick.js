var mouth = document.getElementById("mouth");
var lis = mouth.getElementsByTagName("a");
lis[3].className = 'current';
for (var i = 0; i < lis.length; i++) {
    lis[i].setAttribute('index', 4 - i);
    lis[i].onclick = function () {
        for (var i = 0; i < lis.length; i++) {
            lis[i].className = '';
        }
        this.className = 'current';
        index = this.getAttribute('index');
        document.getElementById("text").value = index;


//点击切换月份
        //重新提交请求到profitRate
        loadDataNav(option3);
        myChartNav.setOption(option3);
        // loadData2(option);
        // myChart.setOption(option);
        loadDataProfitRate(option2);
        myChartProfitRate.setOption(option2);


        if(ifChange==1) {
            loadData(option);  //加载数据到option
            myChart.setOption(option);  //设置option

            clickTimes2 = clickTimes;
            clickTimes = 1;
            for (var i = 0; i < combinArray.length; i++) {
                document.getElementById("binv").value = combinArray[i];
                //重新提交请求到profit
                loadData3(option);
            }
        }else{
            loadData4(option);  //加载数据到option
            myChart.setOption(option);  //设置option
        }


        function loadDataBoxInit() {
            mD.length=0;
            sR.length=0;
            v.length=0;
        }
        loadDataBoxInit();
        myChartBox.setOption(optionBox);
        loadDataBox();
        myChartBox.setOption(optionBox);


    }
}