<%--
  Created by IntelliJ IDEA.
  User: 丰丰
  Date: 2021/6/15
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
    <script src="ecStat.js"></script>
    <%--<script src="echarts.min.js"></script>--%>
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link type="text/css" rel="styleSheet" href="echarts.css" />
    <script>
        var index;var vID;var clickTimes=1;var combinArray=new Array();var clickTimes2=1;var ifChange=1;
    </script>
</head>
<body οnlοad="loadData()">
<div id="wrap">
    <form id="loginForm" method="post">
        <input
                id="text"
                type="hidden"
                name="index"
                value="1"
        />
        <input id="binv" type="hidden" name="bigv"/>
    </form>

    <div id="header">
        <h1>投资大V实盘研究</h1>
    </div>
    <div class="topnav" id="mouth">
        <a href="#" class="a1">近1月</a>
        <a href="#" class="a1">近3月</a>
        <a href="#" class="a1">近6月</a>
        <a href="#" class="a1">近一年</a>
        <a href="#" style="float: right" id="clean-btn" class="a1">清空图表</a>
        <a href="#" style="float: right" id="change-btn" class="a1">多个组合对比</a>
    </div>
    <div id="main">
        <div class="combotable-wrap" id="comBinArray-out">
            <div class="combotable" id="comBinArray"></div>
        </div>
        <div class="details-one">
            <span style="font-weight: bold;font-size: 20px">收益金额折线图简介</span></br>
            <span style="font-family: 'Microsoft Yi Baiti'">折线图展示了‘组合’每日收益的波动情况</span></br>
            <span style="font-family: 'Microsoft Yi Baiti'">折线图上的每一点表示的是一个/多个‘组合’在所选时间段内每天的收益情况</span>
        </div>
        <div class="block-one" id="myLineDiv"></div>

        <div class="details-firstintwo">
            <span style="font-weight: bold;font-size: 20px">单位净值折线图简介</span></br>
            <span style="font-family: 'Microsoft Yi Baiti'">折线图展示了‘组合’每日单位净值的波动情况</span></br>
            <span style="font-family: 'Microsoft Yi Baiti'">折线图同时提供了‘组合’的日涨幅波动曲线用于参考，协助分析</span></br>
        </div>
        <div class="details-secondintwo">
            <span style="font-weight: bold;font-size: 20px">收益率折线图介绍</span></br>
            <span style="font-family: 'Microsoft Yi Baiti'">折线图展示了‘组合’每日收益率的波动情况</span></br>
            <span style="font-family: 'Microsoft Yi Baiti'">折线图同时提供了参考标的曲线用于参考，对比，分析</span>
        </div>
        <div class="block-firstintwo" id="myLineDiv-nav"></div>
        <div class="block-secondintwo" id="myLineDiv-profitRate"></div>
        <div class="details-one">
            <span style="font-weight: bold;font-size: 16px">散点图简介</span></br>
            <span style="font-family: 'Microsoft Yi Baiti';font-size: 14px">横轴表示各个组合的市值，纵轴表示了三种指标的情况</span></br>
            <span style="font-family: 'Microsoft Yi Baiti';font-size: 14px">散点图用于直观展现组合市值与各种指标的关系，协助分析</span></br>
            <span style="font-family: 'Microsoft Yi Baiti';font-size: 14px">大V榜单上的组合数量即样品数量较少，因此所展示的关系不构成一般性，仅供参考</span></br>
        </div>
        <div class="block-one" id="box"></div>
        <div class="details-one">
            <span style="font-weight: bold;font-size: 16px">粉丝数量-收益介绍</span></br>
            <span style="font-family: 'Microsoft Yi Baiti';font-size: 14px">横轴表示大v的粉丝数量，纵轴表示大V的平均年化收益金额</span></br>
            <span style="font-family: 'Microsoft Yi Baiti';font-size: 14px">散点图用于直观展现大v的收益情况与其粉丝数量的关系，协助分析</span></br>
            <span style="font-family: 'Microsoft Yi Baiti';font-size: 14px">大V榜单上的大V数量即样品数量较少，因此所展示的关系不构成一般性，仅供参考</span></br>


        </div>
        <div class="block-one" id="box2"></div>

        <div class="bigvtable-wrap" id="bigvArray-out">
            <div class="bigvtable" id="bigvArray"></div>
        </div>

    </div>
    <div id="footer">
        <div class="popup_copyright">
            &copy; 2021 <span>19th group</span>
        </div>
    </div>
</div>
</body>
<script src="profitImg.js"></script>
<script src="profitRateImg.js"></script>
<script src="navImg.js"></script>
<script src="bigvImg.js"></script>
<script async src="comBinImg.js"></script>
<script src="sandian.js"></script>
<script src="changeTimeClick.js"></script>
<script src="clean-click.js"></script>
<script src="fansIncomeImg.js"></script>
<script src="change-click.js"></script>
</html>
