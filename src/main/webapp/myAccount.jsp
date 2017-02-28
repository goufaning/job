<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>框架锚点Jquery插件</title>
    <%@ include file="link.jsp" %>
    <link type="text/css" rel="stylesheet" href="css/popuo-box.css">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<%@ include file="header.jsp" %>
<jsp:include page="menu.jsp"></jsp:include>
    <div id="jcContent">
        <%@ include file="readresume.jsp" %>
        <%@ include file="addresume.jsp" %>
        <jsp:include page="joblist.jsp"></jsp:include>
        <div style="height: 1000px;width: 100%;display: none;background-color: #3eb991">


        </div>
        <jsp:include page="appliedjob.jsp"></jsp:include>

    </div>
</body>
</html>
