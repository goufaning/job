<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="link.jsp" %>
    <script>
        $(document).ready(function() {
            $("#menu5").addClass("select").siblings().removeClass("select");
        });
    </script>
    <style type="text/css">
        .list {
            margin: 10px 50px;
            width: 850px;
            height:350px;
            background-color: honeydew;
        }
        .jcContent img {
            width: 45%;height: 250px;border: 1px solid #CFCFCF;
            padding: 1em;float:left;margin-right: 10px
        }
        .info {
            width: 41.66666667%;height:250px;float: left;display: block;background-color: white;padding: 1em 2em;
        }
        .info p {
            font-size: 0.9em;color: #a3a3a3;line-height: 1.8em;padding: 0.4em 0;
        }
        .info .one {
            color: #000;margin: 0 30px 0 0;font-weight: bold;
        }
        .info .two {
            margin: 0 0em 0 1em;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<div class="jcContent" style="background-color: honeydew">
    <span class="jcTitle">招聘职位列表</span>
    <c:forEach var="job" items="${joblist}">
    <div class="list">
        <img src="images/a2.jpg" alt="img02" >
        <div class="info">
            <h3>${job.jobName}</h3><h4>${job.company}</h4>
            <p>
                <span class="one" >工作地点</span>：
                <span class="two">${job.workPlace}</span></p>
            <p>
                <span class="one" >学历要求 </span>：
                <span class="two" >${job.education}</span></p>
            <p>
                <span class="one" >薪水 </span>：
                <span class="two" >${job.salary}</span></p>
            <ul class="nav navbar-nav navbar-right margin-top cl-effect-2">
                <li class="button"><a style="width: 80px;float: right;" href="${pageContext.request.contextPath}/JobServlet?jobid=${job.id}">详细>>></a></li>
            </ul>
        </div>
    </div>
    </c:forEach>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

