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
</head>
<body>

<jsp:include page="common/menu.jsp"/>

<div class="container">
    <div class="row clearfix" style="margin-top: 10%">

        <div class="col-md-2 column">

        <div class="col-md-10 column">
            <%--<label><spring:message code="profile.personal_setting"/></label>--%>
            <select class="form-control" id="select_language" style="margin-left: 150%">
                <option>English</option>
                <option>中文</option>
            </select>
            <button type="button" class="btn btn-default" style="margin-left: 150%">
                <a id="select_language_submit" href="/setting/changeLanguage?lang=en_US"><spring:message code="settings.language.submit"/> </a>
            </button>

        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/web-resources/js/setting_language.js"></script>

</body>
</html>
