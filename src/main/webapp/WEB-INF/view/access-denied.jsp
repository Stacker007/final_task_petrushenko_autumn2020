<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
<%@include file='/WEB-INF/view/css/simply.css' %>
<%@include file='/WEB-INF/view/css/access-denied.css' %>


</style>
<html>
<head>
<meta charset="utf-8">
<title>403 | Simply</title>
<meta name="generator" content="WYSIWYG Web Builder 14 - http://www.wysiwygwebbuilder.com">
<link href="https://fonts.googleapis.com/css?family=Montserrat:900" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat:800" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Geometr415+Blk+BT" rel="stylesheet">
<link href="simply.css" rel="stylesheet">
<link href="access-denied.css" rel="stylesheet">
<script type="text/javascript">
    <%@include file="/WEB-INF/view/js/jquery-1.12.4.min.js"%>
</script>
<script type="text/javascript">
    <%@include file="/WEB-INF/view/js/wb.parallax.min.js"%>
</script>

<script>
$(document).ready(function()
{
   $('#Layer1').parallax();
});
</script>
</head>
<body>
<div id="container">
</div>
<div id="Layer1" style="position:absolute;text-align:center;left:0px;top:0px;width:100%;height:100%;z-index:4;">
<div id="Layer1_Container" style="width:970px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
<div id="wb_Text1" style="position:absolute;left:120px;top:33px;width:250px;height:66px;text-align:center;z-index:0;">
<span style="color:#FFFFFF;font-family:'Montserrat';font-weight:900;font-size:48px;">SIMPLY</span></div>
<div id="wb_Text2" style="position:absolute;left:120px;top:99px;width:250px;height:24px;text-align:center;z-index:1;">
<span style="color:#3F7CBF;font-family:'Montserrat';font-weight:800;font-size:17px;">The simplest TO-DO list</span></div>
<div id="wb_Text6" style="position:absolute;left:138px;top:459px;width:335px;height:33px;z-index:2;">
<span style="background-color:#000000;color:#FFFFFF;font-family:'Montserrat';font-weight:800;font-size:24px;"><a href="${pageContext.request.contextPath}/login">You&nbsp; can go to login page</a></span></div>
<div id="wb_Image1" style="position:absolute;left:138px;top:183px;width:318px;height:276px;z-index:3;">
<img src="${pageContext.request.contextPath}/images/403.png" id="Image1" alt=""></div>
</div>
</div>
</body>
</html>
