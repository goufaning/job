<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <%@ include file="link.jsp" %>
    <link type="text/css" rel="stylesheet" href="css/readResume.css">
    <script>
        $(document).ready(function() {
            $("#menu2").addClass("select").siblings().removeClass("select");
        });
    </script>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<div id="readResume" class="jcContent" >
    <span class="jcTitle">简历</span>
    <table width="95%" border=0 cellspacing="0" cellpadding="10" align=center>
        <tr height=70  align='center'>
            <td width=720 colspan=6 align=center>
                <b>基本信息</b>
                <span style="float: right;background-color:#3eb991;padding: 5px; font-size: 16px;display: block"><a href="${pageContext.request.contextPath}/DeleteResumeServlet">删除简历</a></span>
                <hr/>
            </td>
        </tr>
        <tr height=50 >
            <td width=15% align=center>姓名：</td>
            <td width=25% align=center>${requestScope.resume.name}</td>
            <td width=15% align=center>性别：</td>
            <td width=25% align=center>${requestScope.resume.sex}</td>
            <td width=20% colspan=2 rowspan=4>
                <img src="${pageContext.request.contextPath}/images/${requestScope.resume.imgurl}" alt="照片" style="width: 170px;height: 200px;border: 1px solid" />
            </td>
        </tr>
        <tr height=50 >
            <td align=center>年龄：</td>
            <td align=center>${requestScope.resume.age}</td>
            <td align=center>毕业学校：</td>
            <td align=center>${requestScope.resume.university}</td>
        </tr>
        <tr height=50 >
            <td align=center>专业</td>
            <td align=center>${requestScope.resume.major}</td>
            <td align=center>学历</td>
            <td align=center>${requestScope.resume.education}</td>
        </tr>
        <tr height=50 >
            <td align=center>电子邮箱：</td>
            <td align=center>${requestScope.resume.email}</td>
            <td align=center>联系电话：</td>
            <td align=center>${requestScope.resume.telephone}</td>
        </tr>
        <tr height=70 >
            <td width=720 colspan=6 >
                <b>学习经历</b>
                <hr/>
            </td>
        </tr>
        <tr height=150>
            <td colspan=6>
                ${requestScope.resume.projectexperience}
            </td>
        </tr>
        <tr height=70  align='center'>
            <td width=720 colspan=6 align=center>
                <b>工作经历</b>
                <hr/>
            </td>
        </tr>
        <tr height=150>
            <td   colspan=6>
                ${requestScope.resume.workexperience}
            </td>
        </tr>
        <tr height=70  align='center'>
            <td width=720 colspan=6 align=center>
                <b>个人评价</b>
                <hr/>
            </td>
        </tr>
        <tr height=150>
            <td colspan=6>
                ${requestScope.resume.evaluation}
            </td>
        </tr>
    </table>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>


