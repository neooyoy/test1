<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2016/3/10
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  
  </body>
</html>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="com.utils.ConfigProperties" pageEncoding="utf-8"%>

<html>
<head>
  <title>ComboBox Actions - jQuery EasyUI Demo</title>
</head>
<body>

hello!
<div id="speed"></div>

<%
  String speed = ConfigProperties.speed;
  System.out.println(speed);

  if (speed.equals("3"))
  {
%>
<script type="text/javascript">
  var speed = '<%=speed%>';
  document.getElementById("speed").innerHTML = speed;
</script>
<%
  }
  else
  {
%>
<script type="text/javascript">
  var speed = '<%=speed%>';
  document.getElementById("speed").innerHTML = 'fdsfdsfds';
</script>
<%
  }
%>

<div>hello world!</div>

</body>
</html>
