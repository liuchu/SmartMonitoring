<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: no one
  Date: 2017/12/20
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <title>Monitoring</title>

    <link rel='stylesheet prefetch' href='${pageContext.request.contextPath}/web-resources/css/jquery-ui.css'>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="${pageContext.request.contextPath}/web-resources/css/bootstrap.css" rel="stylesheet">

    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <link src="${pageContext.request.contextPath}/web-resources/css/bootstrap-theme.min.css"/>

    <link rel='stylesheet' href='${pageContext.request.contextPath}/web-resources/css/style.css'>

<aside class="sidebar">
    <div id="leftside-navigation" class="nano">

        <ul class="nano-content">
            <li style="margin-top: 10%">
                <a href="/monitoring"><i class="fa"></i>
                    <span style="font-size: x-large;margin-bottom: 20%"><spring:message code="monitoring.brand"/></span>
                </a>
            </li>
                        
            <li>
                <a href="/monitoring"><i class="fa fa-dashboard"></i><span><spring:message code="menu.dashboard"/></span></a>
            </li>

            </li>

            <li class="sub-menu">
                <a href="javascript:void(0);"><i class="fa fa-table"></i>
                    <span><spring:message code="menu.live"/></span><i class="arrow fa fa-angle-right pull-right"></i>
                </a>

                <ul>
                    <li> <a href="/monitoring/live/basic"><spring:message code="live.basic"/></a>
                    </li>

                    <li><a href="/monitoring/live/basic"><spring:message code="live.advanced"/></a></li>

                </ul>
            </li>

            <li class="sub-menu">
                            <a href="javascript:void(0);"><i class="fa fa-bar-chart-o"></i><span><spring:message code="menu.report"/></span><i class="arrow fa fa-angle-right pull-right"></i></a>
                            <ul>
                                <li> <a href="/monitoring/report/line"><spring:message code="report.chart"/></a>
                                </li>
                            </ul>
                        </li>

            <li class="sub-menu">
                            <a href="javascript:void(0);"><i class="fa fa-cogs"></i><span><spring:message code="menu.settings"/></span><i class="arrow fa fa-angle-right pull-right"></i></a>
                            <ul>

                                <li ><a href="/monitoring/setting_language"><spring:message code="settings.language"/></a>
                                </li>

                            </ul>
                        </li>

        </ul>
    </div>
</aside>

<script src='${pageContext.request.contextPath}/web-resources/js/jquery.min.js'></script>
<script src='${pageContext.request.contextPath}/web-resources/js/jquery-ui.min.js'></script>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<%--<script src="${pageContext.request.contextPath}/web-resources/js/jquery-3.2.1.min.js"></script>--%>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/web-resources/js/bootstrap.min.js"></script>

<script  src="${pageContext.request.contextPath}/web-resources/js/index.js"></script>

<script src="${pageContext.request.contextPath}/web-resources/js/chart.js"></script>

<script  src="${pageContext.request.contextPath}/web-resources/js/monitoring.js"></script>

