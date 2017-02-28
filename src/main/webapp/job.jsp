<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工作信息列表</title>
    <%@ include file="link.jsp" %>
    <script>
        $(document).ready(function() {
            $("#menu5").addClass("select").siblings().removeClass("select");
            $("#company").click(function () {
            })
            $("#companymassage").hide(); //默认隐藏
            $("#company").on("click",function(){
                $("#companymassage").toggle();//显示隐藏切换
            })
        });
    </script>
    <style type="text/css">
        .list {
            margin: 10px 50px;
            height:auto;
            padding-bottom: 100px;
            background-color: honeydew;
        }
        .jcContent img {
            width: 45%;height: 250px;border: 1px solid #CFCFCF;
            padding: 1em;margin: 0 16%;
        }
        .info {
            height:auto;display: block;background-color: white;padding: 1em 2em;
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
        #company {
            display: block;
            float: right;
            background-color: #5cd053;
            text-align: center;
            width: 50px;
            height: 30px;
          }
        #companymassage {
            width:auto;
            margin-left:1px;
            font-family:Arial, Helvetica, sans-serif;
            font-size:13px;
            color:#5f5f5f;
            line-height:35px;
            text-transform:uppercase;
            width: 95%;height: 500px;border: 1px solid forestgreen
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="menu.jsp" %>
<%@ include file="login.jsp" %>
<div class="jcContent" style="background-color: honeydew">
    <span class="jcTitle">职位详细信息</span>
        <div class="list">
            <br/>
            <div class="info">
                <h3>${job.jobName}</h3>
                <p>
                    <span class="one" >工作地点</span>：
                    <span class="two">${job.workPlace}</span></p>
                <p>
                    <span class="one" >学历要求 </span>：
                    <span class="two" >${job.education}</span></p>
                <p>
                    <span class="one" >薪水 </span>：
                    <span class="two" >${job.salary}</span></p>
                <p>
                    <span class="one" >工作部门 </span>：
                    <span class="two" >${job.department}</span></p>
                <p>
                    <span class="one" >工作描述 </span>：
                    <span class="two" >${job.detail}</span></p>
                <p>
                    <span class="one">公司</span>:
                    <span class="two" >${job.company}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="company" href="#">更多</a></span></p>
                    <div id="companymassage" style="">
                            ${job.companymassage}
                    </div>
                <ul class="nav navbar-nav navbar-right margin-top cl-effect-2">
                    <li class="button"><a style="width: 80px;float: right;" href="${pageContext.request.contextPath}/ApplyJobServlet?jobid=${job.id}">申请</a></li>
                </ul>
            </div>
        </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>