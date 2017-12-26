/**
 * Created by no one on 2017/12/26.
 *
 */

$(document).ready(function(){

    $.ajax({
        url : "serverInfo/latest",
        async : false,
        type:"GET",
        success : function(data,status,jqXHR){
            //alert("status:"+jqXHR.status);

            if(jqXHR.status == 200){
                var jsonObj = JSON.parse(data); //由JSON字符串转换为JSON对象

                var jsonArray = jsonObj.response;

                console.log(jsonArray.toString());

                /*for (var i=0;i<jsonArray.length;i++) {

                }*/


            }else{
                $("#system_message").html("Server internal error");
            }

        },
        error : function (jqXHR) {
            $("#system_message").html("can't connect server:");
        }

    });

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

});
