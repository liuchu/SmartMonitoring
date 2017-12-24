<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: chuliu
  Date: 2017/12/23
  Time: 10:14
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

    <div class="row clearfix" style="margin-top: 130px">
        <%--<div class="col-md-2 column">

        </div>--%>
        <div class="col-md-12 column">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <spring:message code="menu.live"/>
                    </h3>
                </div>
                <div class="panel-body">
                    <table class="table">
                        <>
                        <tr>
                            <th>
                                <spring:message code="live.table_ip"/>
                            </th>
                            <th>
                                <spring:message code="live.table_status"/>
                            </th>
                            <th>
                                <spring:message code="live.table_cpu"/>
                            </th>
                            <th>
                                <spring:message code="live.table_memory"/>
                            </th>
                            <th>
                                <spring:message code="live.table_disk"/>
                            </th>
                            <th>
                                <spring:message code="live.table_thread"/>
                            </th>
                            <th>
                                <spring:message code="live.table_modify_thread"/>
                            </th>
                            <th>
                                <spring:message code="live.table_start_stop"/>
                            </th>

                        </tr>

                        <tbody>
                        <tr>
                            <td>
                                1.1.1.1
                            </td>
                            <td>
                                Online
                            </td>
                            <td>
                                80%
                            </td>
                            <td>
                                4096/8194
                            </td>
                            <td>
                                512000/512000
                            </td>
                            <td>
                                200/500
                            </td>
                            <td>
                                <input type="text" style="width: 80px"/>
                                <button style="width: 70px"><spring:message code="live.table_modify_thread.submit"/></button>
                            </td>
                            <td>
                                <button><spring:message code="live.table_start_stop"/></button>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                1.1.1.1
                            </td>
                            <td>
                                Online
                            </td>
                            <td>
                                80%
                            </td>
                            <td>
                                4096/8194
                            </td>
                            <td>
                                512000/512000
                            </td>
                            <td>
                                200/500
                            </td>

                        </tr>

                        <tr>
                            <td>
                                1.1.1.1
                            </td>
                            <td>
                                Online
                            </td>
                            <td>
                                80%
                            </td>
                            <td>
                                4096/8194
                            </td>
                            <td>
                                512000/512000
                            </td>
                            <td>
                                200/500
                            </td>
                        </tr>

                        <tr>
                            <td>
                                1.1.1.1
                            </td>
                            <td>
                                Online
                            </td>
                            <td>
                                80%
                            </td>
                            <td>
                                4096/8194
                            </td>
                            <td>
                                512000/512000
                            </td>
                            <td>
                                200/500
                            </td>
                        </tr>

                        <tr>
                            <td>
                                1.1.1.1
                            </td>
                            <td>
                                Online
                            </td>
                            <td>
                                80%
                            </td>
                            <td>
                                4096/8194
                            </td>
                            <td>
                                512000/512000
                            </td>
                            <td>
                                200/500
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
                <div class="panel-footer">
                    Panel footer
                </div>
            </div>

        </div>
    </div>

</div>

</body>
</html>
