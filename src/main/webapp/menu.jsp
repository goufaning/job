<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css"rel="stylesheet" href="css/menu.css">
<script type="text/javascript" src="js/menu.js"></script>
<div id="jcFrame">
    <ul id="jcSide">
        <li id="menu1" style="margin-top: 10px"><a href="index.jsp">主页<img class="icon" src="images/index.png"/></a></li>
        <li id="menu2"><a href="${pageContext.request.contextPath}/ReadResumeServlet">查看简历<img class="icon" src="images/10-Resume.png"/></a></li>
        <li id="menu3"><a href="${pageContext.request.contextPath}/HasResumeServlet">添加简历<img class="icon" src="images/add_document.png"/></a></li>
        <li id="menu7"><a href="${pageContext.request.contextPath}/PhotoServlet">简历照片设置<img class="icon" src="images/head.png"/></a></li>
        <li id="menu4"><a href="${pageContext.request.contextPath}/GetResumeServlet">修改简历<img class="icon" src="images/edit.png"/></a></li>
        <li id="menu5"><a href="${pageContext.request.contextPath}/JobListServlet">查看职位<img class="icon" src="images/list.png"/></a></li>
        <li id="menu6"><a  href="${pageContext.request.contextPath}/MyJobServlet">查看已申请职位<img class="icon" src="images/49-tick-outline.png"/></a></li>
    </ul>
</div>
