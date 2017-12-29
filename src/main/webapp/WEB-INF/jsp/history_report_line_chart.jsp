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

<div class="container" style="color: snow">

    <h1 id="system_message_dashboard" style="text-align:center;color: red"></h1>

    <div class="row clearfix" style="margin-top: 130px">

        <div class="col-md-2 column"> </div>

        <div class="col-md-10 column">

            <div style="margin-left: 2%;">

                    <select class="form-control" id="select_ip" >
                        <option selected="selected">211.211.211.101</option>
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

                    <input id="chart_date" type="date" value="2017-12-01" width="100%" style="color:darkmagenta"/>

                <br/>

                    <button class="btn-info" id="chart_submit"><spring:message code="report.submit"/></button>

            </div>

        </div>

    </div>


    <div class="row clearfix">
        <div class="col-md-2 column"> </div>
        <div class="col-md-10 column">
            <div style="margin-left: 2%">
                <label style="color: white"><spring:message code="report.label.current_ip"/>:</label>
                <strong><span style="color: darkgreen" id="selectedIP"></span></strong>
                <br/>
                <label style="color: white"><spring:message code="report.label.current_date"/>:</label>
                <strong><span style="color: darkgreen" id="selectedDate"></span></strong>
            </div>
        </div>
    </div>


    <div class="row clearfix">

        <div class="col-md-2 column">
        </div>

        <div class="col-md-10 column">

            <div style="margin-left: 2%">
                <h2><spring:message code="report.chart_title.cpu"/></h2>

                <div class="tabbable" id="tabs-720472">
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#panel-731880" data-toggle="tab"><spring:message code="report.submit.chart_option.line"/></a>
                        </li>
                        <li>
                            <a href="#panel-223748" data-toggle="tab"><spring:message code="report.submit.chart_option.bar"/></a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="panel-731880">
                            <canvas id="line_chart_cpu" height="450" width="1000"></canvas>
                        </div>
                        <div class="tab-pane" id="panel-223748">
                            <canvas id="bar_chart_cpu" height="450" width="1000"></canvas>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-2 column"> </div>

            <div class="col-md-10 column">

                <div style="margin-left: 2%">
                    <h2><spring:message code="report.chart_title.memory"/></h2>

                    <div class="tabbable" id="tabs-720473">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#panel-731881" data-toggle="tab"><spring:message code="report.submit.chart_option.line"/></a>
                            </li>
                            <li>
                                <a href="#panel-223749" data-toggle="tab"><spring:message code="report.submit.chart_option.bar"/></a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="panel-731881">
                                <canvas id="line_chart_memory" height="450" width="1000"></canvas>
                            </div>
                            <div class="tab-pane" id="panel-223749">
                                <canvas id="bar_chart_memory" height="450" width="1000"></canvas>
                            </div>
                        </div>
                    </div>

                    <%--<canvas id="line_chart_memory" height="450" width="1000"></canvas>--%>
                </div>

            </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-2 column"> </div>

            <div class="col-md-10 column">

                <div style="margin-left: 2%">
                    <h2><spring:message code="report.chart_title.disk"/></h2>

                    <div class="tabbable" id="tabs-720474">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#panel-731882" data-toggle="tab"><spring:message code="report.submit.chart_option.line"/></a>
                            </li>
                            <li>
                                <a href="#panel-223750" data-toggle="tab"><spring:message code="report.submit.chart_option.bar"/></a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="panel-731882">
                                <canvas id="line_chart_thread" height="450" width="1000"></canvas>
                            </div>
                            <div class="tab-pane" id="panel-223750">
                                <canvas id="bar_chart_thread" height="450" width="1000"></canvas>
                            </div>
                        </div>
                    </div>

                </div>

                </div>

            </div>

    <div class="row clearfix">

        <div class="col-md-2 column"> </div>

            <div class="col-md-10 column">

                <div style="margin-left: 2%">
                    <h3><spring:message code="report.chart_title.thread"/></h3>

                    <div class="tabbable" id="tabs-720475">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#panel-731883" data-toggle="tab"><spring:message code="report.submit.chart_option.line"/></a>
                            </li>
                            <li>
                                <a href="#panel-223751" data-toggle="tab"><spring:message code="report.submit.chart_option.bar"/></a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="panel-731883">
                                <canvas id="line_chart_disk" height="450" width="1000"></canvas>
                            </div>
                            <div class="tab-pane" id="panel-223751">
                                <canvas id="bar_chart_disk" height="450" width="1000"></canvas>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
    </div>


</div>

<script src="${pageContext.request.contextPath}/web-resources/js/history_report_line_chart.js"></script>

</body>
</html>
