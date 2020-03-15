<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
<%@include file='/WEB-INF/view/css/simply.css' %>
<%@include file='/WEB-INF/view/css/login.css' %>


</style>
<html>
<head>
<meta charset="utf-8">
<title>Login | Simply</title>
<meta name="generator" content="WYSIWYG Web Builder 14 - http://www.wysiwygwebbuilder.com">
<link href="https://fonts.googleapis.com/css?family=Montserrat:900" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat:800" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

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
<div id="Layer1" style="position:absolute;text-align:center;left:0px;top:0px;width:100%;height:100%;z-index:13;">
<div id="Layer1_Container" style="width:970px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
<div id="wb_Text1" style="position:absolute;left:120px;top:33px;width:250px;height:66px;text-align:center;z-index:5;">
<span style="color:#FFFFFF;font-family:'Montserrat';font-weight:900;font-size:48px;">SIMPLY</span></div>
<div id="wb_Text2" style="position:absolute;left:120px;top:99px;width:250px;height:24px;text-align:center;z-index:6;">
<span style="color:#3F7CBF;font-family:'Montserrat';font-weight:800;font-size:17px;">The simplest TO-DO list</span></div>
<div id="wb_Form1" style="position:absolute;left:110px;top:145px;width:265px;height:261px;z-index:7;">
<form name="registration" method="post" action="" id="Form1">
<div id="wb_Text3" style="position:absolute;left:49px;top:22px;width:166px;height:24px;text-align:center;z-index:0;">
<span style="color:#3F7CBF;font-family:'Montserrat';font-weight:800;font-size:17px;">Login:</span></div>
<input type="text" id="Editbox1" style="position:absolute;left:56px;top:58px;width:141px;height:18px;z-index:1;" name="login" value="" spellcheck="false" placeholder="Login">
<input type="password" id="Editbox2" style="position:absolute;left:56px;top:109px;width:141px;height:18px;z-index:2;" name="password" value="" spellcheck="false" placeholder="Password">
<input type="submit" id="Button1" name="" value="Sign IN" style="position:absolute;left:75px;top:154px;width:115px;height:35px;z-index:3;">
<div id="wb_Text4" style="position:absolute;left:7px;top:204px;width:250px;height:48px;text-align:center;z-index:4;">
<span style="color:#3F7CBF;font-family:Montserrat;font-size:17px;"><u><a href="${pageContext.request.contextPath}/reg">If you don't have an account yet, click here</a></u></span></div>
<div id="wb_Text5" style="position:absolute;left:7px;top:189px;width:249px;height:24px;text-align:center;z-index:5;">
<span style="color:#FF0000;font-family:Montserrat;font-size:17px;"><strong><u>${message}</u></strong></span></div>
</form>
</div>
</div>
</div>
</body>
</html>
