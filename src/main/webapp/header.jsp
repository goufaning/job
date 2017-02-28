<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>

</script>
<div style="position: fixed;top: 0;left:0;right:0;z-index: 9999;height:auto ">
        <div style="height: 60px;background-color: #0B0354">
            <div class="headerfont">
                <h1><a href="index.jsp">XX企业<br /></a></h1>
            </div>
        <c:choose>
            <c:when test = "${ sessionScope.user eq null }">
            <div class="loginbutton">
                <div id="loginpop"><a href="#" id="loginButton">登陆</a>
                </div>
            </div>
            </c:when>
            <c:otherwise>
            <div class="user">
                <a href="index.jsp" id="user"><img src="images/user.png"></a>
                <a href="${pageContext.request.contextPath}/LoginOutServlet"><img src="images/log-off.png"></a>
            </div>
            </c:otherwise>
        </c:choose>
            <script src="js/menu_jquery.js"></script>
        </div>
</div>
