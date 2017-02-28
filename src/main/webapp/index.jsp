<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>招聘网</title>
    <%@ include file="link.jsp" %>
    <link href="css/index.css" rel="stylesheet" type="text/css"/>
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<%@ include file="header.jsp" %>
<c:choose>
    <c:when test = "${ sessionScope.user eq null }">
        <%@ include file="login.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file="menu.jsp" %>
        <script>
            $("#menu1").addClass("select").siblings().removeClass("select");
        </script>
    </c:otherwise>
</c:choose>

<div class="banner1">
    <div id="smalltitle">
        <h1>招聘网</h1>
        <p>本网站会发布大量招聘信息，希望大家可以在这找到一份满意的工作！</p>
        <a>了解更多>>></a>
    </div>
</div>

<div id="grids">
    <div id="welcome">
        <h2>招聘信息</h2>
    </div>
    <div id="container">
        <div>
            <ul>
                <c:forEach var="job" items="${joblist}" begin="1" end="6" step="1">
                    <li class="grid">
                        <figure>
                            <img src="images/g1.png" alt="">
                            <figcaption style="margin-bottom: 20px">
                                <h3>${job.jobName}</h3>
                                <span>${job.company}</span>
                            </figcaption>
                        </figure>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div style="clear: both"></div>
        <div class="clearfix">
            <ul>
                <li class="button"><a href="readjob.jsp" style="color: #27da93"><span>详细>>></span></a></li>
            </ul>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
