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

<div class="container">
    <div class="row clearfix" style="margin-top: 130px">
        <div class="col-md-6 column">
            <h2>
                <spring:message code="dashboard.cpu_title"/>
            </h2>
            
            <canvas id="pei_1" height="360" width="520" style="padding-top: 5%"></canvas>
            <%--<div style="text-align:center;clear:both;">
                <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
                <script src="/follow.js" type="text/javascript"></script>
            </div>--%>
        </div>
        <div class="col-md-6 column">
            <h2>
                <spring:message code="dashboard.online_title"/>
            </h2>
            <canvas id="pei_2" height="360" width="520" style="padding-top: 5%"></canvas>
        </div>

    </div>

    <div class="row clearfix" >
        <div class="col-md-6 column">
            <h2>
                <spring:message code="dashboard.status_title"/>
            </h2>
            <canvas id="pei_3" height="360" width="520" style="padding-top: 5%"></canvas>
        </div>
    </div>

</div>

<script>

    var drawCircle = function(canvasId, data_arr, color_arr, text_arr){
        var drawing = document.getElementById(canvasId);
        if(drawing.getContext) {
            var context = drawing.getContext('2d');
            var radius = drawing.height/2 -20,//半径
                    ox = radius +20, oy = radius +20;//圆心
            var width = 30, height = 10, //图例宽高
                    posX = ox * 2 +20, posY = 30;//图例位置
            var textX = posX + width + 5, textY = posY + 10;//文本位置
            var startAngle = 0, endAngle = 0;//起始、结束弧度
            context.strokeStyle = 'Purple';
            context.lineWidth = 3;
            context.strokeRect(0, 0, drawing.width, drawing.height);
            console.log("plaiting"+canvasId);
            for(var i=0, len=data_arr.length; i<len; i++) {
                //绘制饼图
                console.log("plaiting color:"+color_arr[i]);
                endAngle += data_arr[i] * 2*Math.PI;
                context.fillStyle = color_arr[i];
                context.beginPath();
                context.moveTo(ox, oy);
                context.arc(ox, oy, radius, startAngle, endAngle, false);
                context.closePath();
                context.fill();
                startAngle = endAngle;
                //绘制图例
                context.fillRect(posX, posY + 20 * i, width, height);
                context.moveTo(posX, posY + 20 * i);
                context.font = 'bold 12px Arial';
                var percent = text_arr[i] + ' : ' + data_arr[i]*100 + '%';
                context.fillText(percent, textX, textY + 20 * i);
            }

        }
    };

    var init = function(){
        var data_arr1 = [0.70, 0.30],
                color_arr1 = ['#F69E00','#36A3B4'],
                text_arr1 =['Intel', 'AMD'];

        var data_arr2 = [0.80, 0.20],
                color_arr2 = ['#35DE1E', '#ED1C24'],
                text_arr2 =['Online', 'Offline'];

        var data_arr3 = [0.60, 0.10, 0.10, 0.20],
                color_arr3 = [ '#FFC90E', '#ED1C24', '#00FF21', '#7F7F7F'],
                text_arr3 =['Normal', 'Busy', 'Free', 'Dead'];

        drawCircle('pei_1', data_arr1, color_arr1, text_arr1);
        drawCircle('pei_2', data_arr2, color_arr2, text_arr2);
        drawCircle('pei_3', data_arr3, color_arr3, text_arr3);
    };

    init();

</script>

</body>
</html>
