<%--
  Created by IntelliJ IDEA.
  User: 丰丰
  Date: 2021/6/9
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="addStageInfServlet"  method="post">
    comName:<input type="text" name="comName"><br/>
    timeQuantum：<input type="text" name="timeQuantum"><br/>
    maxRec：<input type="text" name="maxRec"><br/>
    SharpeRatio：<input type="text" name="SharpeRatio"><br/>
    Volatility：<input type="text" name="Volatility"><br/>
    firstHeavyProp:<input type="text" name="firstHeavyProp"><br/>
    positiveProfitRate:<input type="text" name="positiveProfitRate"><br/>
    profitRec：<input type="text" name="profitRec"><br/>
    conScore：<input type="text" name="conScore"><br/>
    <input type="submit" value="增加">
</form>
</body>
</html>
