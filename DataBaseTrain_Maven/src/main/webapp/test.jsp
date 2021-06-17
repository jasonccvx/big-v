<%--
  Created by IntelliJ IDEA.
  User: 丰丰
  Date: 2021/6/11
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/echarts/3.7.1/echarts.min.js"></script>
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link type="text/css" rel="styleSheet"  href="profitEchars.css" />
    <script>
        var index;var vID;
    </script>
</head>
<body>

<%--<div id="bigvArray-out">--%>
<%--    <div id="bigvArray"><table border="solid" id="bigvTable"><tbody><tr><th>大V名</th><th>粉丝数</th></tr><tr></tr><tr id="Alex价值发现者"> <td><a href="#" id="Alex价值发现者">Alex价值发现者</a></td> <td>14396</td></tr><tr id="东方_财之道"> <td><a href="#" id="东方_财之道">东方_财之道</a></td> <td>59287</td></tr><tr id="二师父定投"> <td><a href="#" id="二师父定投">二师父定投</a></td> <td>31103</td></tr><tr id="二鸟说"> <td><a href="#" id="二鸟说">二鸟说</a></td> <td>67229</td></tr><tr id="基少成多81"> <td><a href="#" id="基少成多81">基少成多81</a></td> <td>24467</td></tr><tr id="徒步滚雪球"> <td><a href="#" id="徒步滚雪球">徒步滚雪球</a></td> <td>3782</td></tr><tr id="星辰在繁华"> <td><a href="#" id="星辰在繁华">星辰在繁华</a></td> <td>12544</td></tr><tr id="沈潜"> <td><a href="#" id="沈潜">沈潜</a></td> <td>32149</td></tr><tr id="火土定投一生"> <td><a href="#" id="火土定投一生">火土定投一生</a></td> <td>13743</td></tr><tr id="红袋鼠与招财猫"> <td><a href="#" id="红袋鼠与招财猫">红袋鼠与招财猫</a></td> <td>12019</td></tr><tr id="老司基一枚"> <td><a href="#" id="老司基一枚">老司基一枚</a></td> <td>74654</td></tr><tr id="老揭看基金"> <td><a href="#" id="老揭看基金">老揭看基金</a></td> <td>81230</td></tr><tr id="股市药丸"> <td><a href="#" id="股市药丸">股市药丸</a></td> <td>28101</td></tr><tr id="萌萌的猪猪侠"> <td><a href="#" id="萌萌的猪猪侠">萌萌的猪猪侠</a></td> <td>45074</td></tr></tbody></table></div>--%>
<%--</div>--%>
<%--<div id="bigvArray-out">--%>
<%--    <div id="bigvArray"></div>--%>
<%--</div>--%>
<%--<script src="bigvImg.js"></script>--%>
<%--<script>--%>

<%--    var vtable = document.getElementById("bigvArray");--%>
<%--    var x = vtable.getElementsByTagName('a');--%>
<%--    for (var i = 0; i < x.length; i++) {--%>
<%--        var XID = x[i].getAttribute('id');--%>
<%--        $(document).on("click",'#'+XID,function () {//注意，这里天坑，自动增加的元素必须用这种方法点击--%>
<%--            for (var i = 0; i < x.length; i++) {--%>
<%--                x[i].className = '';--%>
<%--            }--%>
<%--            this.className = 'current';--%>
<%--            console.log(this.getAttribute('id'));--%>
<%--            var vID = this.getAttribute('id');--%>
<%--            //document.getElementById("binv").value = vID;--%>
<%--            console.log(document.getElementById("binv").value);--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>

<body>
<form id="loginForm" action="sRServlet" method="post"><%--这个盒子是隐藏的，不用理--%>
    <input id="text" type="hidden" name="index" value=1>
    <input id="binv" type="hidden" name="bigv" value="一年以上余粮">
    <input type="submit">
</form>
</body>
</html>
