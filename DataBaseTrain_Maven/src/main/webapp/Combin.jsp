<%--
  Created by IntelliJ IDEA.
  User: 丰丰
  Date: 2021/6/10
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addCombinServlet"  method="post">
comName:<input type="text" name="comName"><br/>
Vname：<input type="text" name="Vname"><br/>
type：<input type="text" name="type"><br/>
annuRate：<input type="text" name="annuRate"><br/>
dayIncrease：<input type="text" name="dayIncrease"><br/>
newNetWorth：<input type="text" name="newNetWorth"><br/>
newMarketValue：<input type="text" name="newMarketValue"><br/>
estabDay：<input type="text" name="estabDay"><br/>
<input type="submit" value="增加">
</form>
</body>
</html>
