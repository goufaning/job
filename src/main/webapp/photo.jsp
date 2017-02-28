<%--
  Created by IntelliJ IDEA.
  User: job
  Date: 2016/11/19
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="link.jsp" %>
    <script>
        $(document).ready(function() {
            $("#menu7").addClass("select").siblings().removeClass("select");
            function getData() {
                window.location.href = "getDataServlet";
            }
        });
        $(document).ready(function() {
            $("#pic").click(function () {
                $("#upload").click();//隐藏了input:file样式后，点击头像就可以本地上传
                $("#upload").on("change",function(){
                    var objUrl = getObjectURL(this.files[0]) ;  //获取图片的路径，该路径不是图片在本地的路径
                    if (objUrl) {
                        $("#pic").attr("src", objUrl) ;      //将图片路径存入src中，显示出图片
                    }
                });
            });
        });
        function getObjectURL(file) {
            var url = null ;
            if (window.createObjectURL!=undefined) { // basic
                url = window.createObjectURL(file) ;
            } else if (window.URL!=undefined) { // mozilla(firefox)
                url = window.URL.createObjectURL(file) ;
            } else if (window.webkitURL!=undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file) ;
            }
            return url ;
        }

    </script>
    <style type="text/css">
        #photo {
            margin-left: 30%;
        }
        .file input {
            position: absolute;
            right: 0;
            top: 0;
            opacity: 0;
        }

        #photo img {
            width: 230px;height: 250px;border: 1px solid #CFCFCF;
            padding: 0.8em;margin-left: 40px;margin-right: 10px;
        }
        #photo li {
            list-style: none;
            margin-top: 60px;
        }
        #photo span {
            display: block;
            width: 170px;
            color: red;
            background: #3eb991;
            text-align: center;
            background: #fff url(images/red_asterisk.png) no-repeat;
        }
    </style>
    <link type="text/css"rel="stylesheet" href="css/form.css">
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<div class="jcContent" style="height: 84.5%">
    <span class="jcTitle">添加简历</span>
    <form id="photo" action="${pageContext.request.contextPath}/ImgServlet" method="post" enctype="multipart/form-data">
        <span>点击图片进行选择</span>
        <ul>
            <li>
                <img id="pic" title="请点击选择图片" src="${pageContext.request.contextPath}/images/${sessionScope.resume.imgurl}"/>
                <a href="javascript:void(0);" class="file">
                    <input id="upload" type="file" name="imgurl" accept="image/*">
                </a>
            </li>
            <li>
                <button class="submit" type="submit" style="margin-left: 110px">上传</button>
            </li>
        </ul>

    </form>
</div>
</body>
</html>
