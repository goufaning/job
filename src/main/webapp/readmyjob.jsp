<%--
  Created by IntelliJ IDEA.
  User: job
  Date: 2016/11/17
  Time: 14:45
  To change this template use File | Settings | File Templates.
<%--
  Created by IntelliJ IDEA.
  User: job
  Date: 2016/11/15
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="link.jsp" %>
    <script>
        $(document).ready(function() {
            $("#menu6").addClass("select").siblings().removeClass("select");
        });
    </script>
    <style type="text/css">
        #mytable {
            width: 800px;
            padding: 0;
            margin: 50px; }
        caption {
            padding: 0 0 5px 0;
            width: 700px;
            font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            text-align: right; }
        th {
            font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            color: #4f6b72;
            border-right: 1px solid #C1DAD7;
            border-bottom: 1px solid #C1DAD7;
            border-top: 1px solid #C1DAD7;
            letter-spacing: 2px;
            text-transform: uppercase;
            text-align: left;
            padding: 6px 6px 6px 12px;
            background: #CAE8EA; }
        th.nobg {
            border-top: 0;
            border-left: 0;
            border-right: 1px solid #C1DAD7;
            background: none; }
        td {
            border-right: 1px solid #C1DAD7;
            border-bottom: 1px solid #C1DAD7;
            background: #fff;
            font-size:11px;
            padding: 6px 6px 6px 12px;
            color: #4f6b72; }
        td.alt {
            background: #F5FAFA;
            color: #797268; }
        th.spec {
            border-left: 1px solid #C1DAD7;
            border-top: 0;
            background: #fff;
            font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
        }
        th.specalt {
            border-left: 1px solid #C1DAD7;
            border-top: 0;
            background: #f5fafa;
            font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            color: #797268; }
        .jcContent {
            margin: 0 auto;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<div style="height: 1000px;background-color: honeydew" class="jcContent">
    <span class="jcTitle">已申请职位</span>
    <table id="mytable" cellspacing="0">
        <tr>
            <th scope="col" abbr="Configurations">序号</th>
            <th scope="col" abbr="Dual 1.8">职位</th>
            <th scope="col" abbr="Dual 2">部门</th>
            <th scope="col" abbr="Configurations">月薪</th>
            <th scope="col" abbr="Dual 1.8">工作地点</th>
            <th scope="col" abbr="Dual 2">状态</th>
        </tr>
        <c:forEach var="job" items="${applications}" varStatus="status">
        <tr>
            <th scope="row" abbr="Model" class="spec"><c:out value="${status.index+1}"> </c:out></th>
            <td>${job.jobName}</td>
            <td>${job.department}</td>
            <th scope="row" abbr="Model" class="spec">${job.salary}</th>
            <td>${job.workPlace}</td>
            <td>待审核</td>
        </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

