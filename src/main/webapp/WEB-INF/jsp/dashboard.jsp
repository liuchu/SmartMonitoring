<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: chuliu
  Date: 2017/12/21
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>

    <meta name = "viewport" content = "initial-scale = 1, user-scalable = no">
    <meta charset="UTF-8">

    <style>
        canvas{
        }
    </style>

</head>

<body>


<jsp:include page="common/menu.jsp"/>

<div class="container" style="width:100%;">

    <h1 id="system_message" style="text-align:center;color: red"></h1>

    <div class="row clearfix" style="margin-top: 130px">
        <div class="col-md-2 column" >
        </div>
        <div class="col-md-5 column" >
            <h2 style="margin-left: 5%">
                <spring:message code="dashboard.cpu_title"/>
            </h2>
            
            <canvas id="pei_1" height="360" width="520" style="padding-top: 5%;margin-left: 5%"></canvas>
            <%--<div style="text-align:center;clear:both;">
                <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
                <script src="/follow.js" type="text/javascript"></script>
            </div>--%>
        </div>
        <div class="col-md-5 column">
            <h2 >
                <spring:message code="dashboard.online_title"/>
            </h2>
            <canvas id="pei_2" height="360" width="520" style="padding-top: 5%"></canvas>
        </div>

    </div>

    <div class="row clearfix" >
        <div class="col-md-2 column" >
        </div>
        <div class="col-md-5 column">
            <h2 style="margin-left: 5%">
                <spring:message code="dashboard.status_title"/>
            </h2>
            <canvas id="pei_3" height="360" width="520" style="padding-top: 5%;margin-left: 5%"></canvas>
        </div>
    </div>

</div>

<script src="${pageContext.request.contextPath}/web-resources/js/dashboard.js"> </script>

</body>
</html>
