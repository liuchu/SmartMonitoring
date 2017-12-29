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

<div class="container" style="width:100%;">

    <h1 id="system_message_live" style="text-align:center;color: red"></h1>

    <div class="row clearfix" style="margin-top: 130px">
        <div class="col-md-2 column">

        </div>
        <div class="col-md-10 column">

            <h2 class="panel-title" style="margin-left: 2%;color: white">
                <spring:message code="menu.live"/>
            </h2>

            <table class="table" id="live_status" style="color: white;margin-left: 2%">
                <tr >
                    <th>
                        <spring:message code="live.table_ip"/>
                    </th>
                    <th>
                        <spring:message code="live.table_status"/>
                    </th>
                    <th>
                        <spring:message code="live.table_cpu_model"/>
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

                <tbody id="live_status_tbody">

                <tr id="tr0">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px" class="btn-success">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>

                <tr id="tr1">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>

                <tr id="tr2">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>

                <tr id="tr3">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>

                <tr id="tr4">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>

                <tr id="tr5">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>

                <tr id="tr6">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>

                <tr id="tr7">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>

                <tr id="tr8">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>

                <tr id="tr9">
                    <td >
                        ?
                    </td >
                    <td>
                        ?
                    </td >
                    <td>
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        ?
                    </td>
                    <td >
                        <input type="text" style="width: 80px;color: black"/>
                        <button style="width: 70px">Submit</button>
                    </td>
                    <td >
                        <button class="btn-info"></button>
                    </td>

                </tr>


                </tbody>
            </table>

        </div>
    </div>

</div>

<script src="${pageContext.request.contextPath}/web-resources/js/live_status.js"> </script>

</body>
</html>
