<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: chuliu
  Date: 2017/12/23
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        canvas{
        }
    </style>
</head>
<body>

<jsp:include page="common/menu.jsp"/>

<div class="container">

    <div class="row clearfix" style="margin-top: 130px">
        <div class="col-md-12 column">
            <div class="btn-group open">
                <select class="form-control" id="select_ip">
                    <option>211.211.211.101</option>
                    <option>211.211.211.102</option>
                    <option>211.211.211.103</option>
                    <option>211.211.211.104</option>
                    <option>211.211.211.105</option>
                    <option>211.211.211.106</option>
                    <option>211.211.211.107</option>
                    <option>211.211.211.108</option>
                    <option>211.211.211.109</option>
                    <option>211.211.211.110</option>
                </select>
                <button type="button" class="btn btn-default">
                    <a id="select_language_submit"><spring:message code="report.submit"/> </a>
                </button>
            </div>
            <div class="btn-group open">
                <select class="form-control" id="select_chart">
                    <option><spring:message code="report.submit.chart_option.line"/></option>
                    <option><spring:message code="report.submit.chart_option.bar"/></option>
                </select>

            </div>
        </div>
        <div class="col-md-12 column" style="margin-top: 50px">
            <label style="color: white"><spring:message code="report.label.current_ip"/>:</label>
            <span style="color: darkgreen">211.211.211.101</span>
        </div>
    </div>

    <div class="row clearfix">

        <div class="col-md-12 column">

            <h3><spring:message code="report.chart_title.cpu"/></h3>
            <canvas id="line_chart_cpu" height="450" width="1000"></canvas>
        </div>

        <div class="col-md-12 column">
            <h3><spring:message code="report.chart_title.memory"/></h3>
            <canvas id="line_chart_memory" height="450" width="1000"></canvas>
        </div>

        <div class="col-md-12 column">
            <h3><spring:message code="report.chart_title.disk"/></h3>
            <canvas id="line_chart_thread" height="450" width="1000"></canvas>
        </div>

        <div class="col-md-12 column">
            <h3><spring:message code="report.chart_title.thread"/></h3>
            <canvas id="line_chart_disk" height="450" width="1000"></canvas>
        </div>

    </div>
</div>

<script src="${pageContext.request.contextPath}/web-resources/js/history_report_line_chart.js"></script>

</body>
</html>
