<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加简历</title>
    <%@ include file="link.jsp" %>
    <link type="text/css"rel="stylesheet" href="css/form.css">
    <script language="javascript" type="text/javascript">
        $(document).ready(function() {
            $("#menu3").addClass("select").siblings().removeClass("select");
            $('#mailerror').hide();
            $('#telerror').hide();
            $('#sub').click(function() {
                if ($('#tel').val().length != 11) {
                    $('#telerror').show();
                    return false;
                } else {
                    $('#telerror').hide();
                    $('#telerror').addClass("right")
                }
                var sqq = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                if (!sqq.test($('#email').val()) || $('#email').val().length < 5) {
                    $('#mailerror').show();
                    return false;
                } else {
                    $('#mailerror').hide();
                };
                $('#resume').submit();
            });
        });
    </script>

</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>

<div class="addresume jcContent" style="background-color: lavender">
    <span class="jcTitle">添加简历</span>
    <form id="resume" class="contact_form" action="${pageContext.request.contextPath}/AddResumeServlet" method="post" name="contact_form">
        <ul>
            <li>
                <b style="color: red">${massage}</b><p class="required_notification">* 表示必填项</p>
            </li>
            <h3>基本信息</h3>
            <hr/>

            <li>
                <span>姓名:</span>
                <input id="name" name="name" type="text" required/>
            </li>
            <li>
                <span>性别:</span>
                <input type="radio" name="sex" value="男" id="male" checked="checked"/><label for="male">男</label>
                <input type="radio" name="sex" value="女" id="female"/><label for="female">女</label>

            </li>
            <li>
                <span>年龄：</span>
                <input type="number"  min="18" max="30" name="age" required>
            </li>
            <li>
                <span>毕业学校</span>
                <input type="text" name="university" required>
            </li>
            <li>
                <span>学历</span>
                <input type="radio" name="education" value="本科" id="bengke" checked="checked"/><label for="bengke">本科</label>
                <input type="radio" name="education" value="专科" id="zhuanke"/><label for="zhuanke">专科</label>
                <input type="radio" name="education" value="研究生" id="yanjie"/><label for="yanjie">研究生</label>
            </li>
            <li>
                <span>专业</span>
                <input type="text" name="major" required>
            </li>
            <li>
                <span>联系电话</span>
                <input id="tel" type="tel" name="telephone" placeholder="请输入11位手机号码" pattern="\d{11}" maxlength="11"  required>
                <span id="telerror" class="form_hint">电话号码格式不正确</span>
            </li>
            <li>
                <span>电子邮件:</span>
                <input id="email" type="text" name="email" placeholder="xxxx@example.com" pattern="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$" required />
                <span id="mailerror" class="form_hint">邮箱格式不正确</span>
            </li>
            <li>
                <span>工作经历:</span>
                <textarea name="workexperience" cols="40" rows="6" ></textarea>
            </li>
            <li>
                <span>项目经历:</span>
                <textarea name="projectexperience" cols="40" rows="6" ></textarea>
            </li>
            <li>
                <span>自我评价:</span>
                <textarea name="evaluation" cols="40" rows="6" required ></textarea>
            </li>
            <li>
                <button id="sub" class="submit" type="submit">提交</button>
            </li>
        </ul>
    </form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

