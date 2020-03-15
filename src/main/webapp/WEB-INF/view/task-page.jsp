<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
<%@include file='/WEB-INF/view/css/simply.css' %>
<%@include file='/WEB-INF/view/css/task-page.css' %>
<%@include file='/WEB-INF/view/base/jquery-ui.min.css' %>

</style>
<html>
<head>
<meta charset="utf-8">
<title>My Tasks | Simply</title>
<meta name="generator" content="WYSIWYG Web Builder 14 - http://www.wysiwygwebbuilder.com">

<link href="https://fonts.googleapis.com/css?family=Montserrat:800" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat:900" rel="stylesheet">

<script type="text/javascript">
    <%@include file="/WEB-INF/view/js/jquery-1.12.4.min.js"%>
</script>
<script type="text/javascript">
    <%@include file="/WEB-INF/view/js/jquery-ui.min.js"%>
</script>
<script>
$(document).ready(function()
{
   $("#ThemeableButton1").button();
});
</script>
</head>
<body>
<div id="container">
<div id="Layer1" style="position:absolute;text-align:center;left:0px;top:0px;width:970px;height:1096px;z-index:7;">
<div id="Layer1_Container" style="width:970px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
<div id="wb_Text2" style="position:absolute;left:63px;top:89px;width:250px;height:24px;text-align:center;z-index:1;">
<span style="color:#3F7CBF;font-family:'Montserrat';font-weight:800;font-size:17px;">The simplest TO-DO list</span></div>
<div id="wb_Text1" style="position:absolute;left:63px;top:23px;width:250px;height:66px;text-align:center;z-index:2;">
<span style="color:#3F7CBF;font-family:'Montserrat';font-weight:900;font-size:48px;">SIMPLY</span></div>
<button type="submit" id="ThemeableButton1" name="" value="Logout" style="position:absolute;left:756px;top:40px;width:123px;height:49px;z-index:3;">Logout</button>
<div id="wb_Text3" style="position:absolute;left:371px;top:52px;width:347px;height:26px;z-index:4;">
<span style="color:#000000;font-family:'Montserrat';font-weight:900;font-size:19px;">Hello, ${login}</span></div>
<div id="Tabs1" style="position:absolute;left:0px;top:143px;width:960px;height:569px;z-index:5;">
<ul>
<li><a href="#tabs1-page-0"><span>Current tasks</span></a></li>
<li><a href="#tabs1-page-1"><span>Bin</span></a></li>
</ul>
<div style="height:541px;" id="tabs1-page-0">
<!-- table_of_today -->
<div id="Html1" style="position:absolute;left:12px;top:30px;width:100px;height:100px;z-index:0">
<table>
<c:forEach items="${troday-list}">
        <tr>
            <td>${items.taskName}</td>
            <td>${items.description}</td>
        </tr>
    </c:forEach>

</table></div>
</div>
<div style="height:541px;" id="tabs1-page-1">
</div>
</div>
</div>
</div>
</div>
</body>
</html>