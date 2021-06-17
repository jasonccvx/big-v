<%--
  Created by IntelliJ IDEA.
  User: 丰丰
  Date: 2021/6/9
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="addNavServlet"  method="post">
    comName:<input type="text" name="comName"><br/>
    time：<input type="text" name="time"><br/>
    nav：<input type="text" name="nav"><br/>
    DailyIncrease：<input type="text" name="DailyIncrease"><br/>
    <input type="submit" value="增加">
</form>

</body>
</html>
