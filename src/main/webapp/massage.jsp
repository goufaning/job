<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <%@ include file="link.jsp" %>
    <meta http-equiv=refresh content="3;url=index.jsp">
    <style type="text/css">
        #massage span {
            width: 300px;
            height: 30px;
            margin: 200px auto;
            display: block;
            font-size: 24px;
            color: #b03535;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>
<div id="massage" style="width: 100%;height:75%;">
    <span>${massage}<br/>页面将在5秒后跳转！！<br/>
        <a href="index.jsp">若没有跳转请点此连接</a></span>

</div>
<%@include file="footer.jsp"%>
</body>
</html>
