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
            var CPUModelIntelNum = 0;
            var CPUModelAMDNum = 0;

            var onlineNum = 0;
            var offlineNum = 0;

            var statusBusyNum = 0;
            var statusNormalNum = 0;
            var statusFreeNum = 0;
            var statusDeadNum = 0;

            if(jqXHR.status == 200){
                var jsonObj = JSON.parse(data); //由JSON字符串转换为JSON对象

                var jsonArray = jsonObj.response;

                //解析JSON
                for(ind in jsonArray){
                    var str = jsonArray[ind];

                    var singleServerJsonObj = JSON.parse(jsonArray[ind]);

                    if (!singleServerJsonObj["online"]) {
                        offlineNum ++;
                        statusDeadNum ++;
                    }else {

                        if (singleServerJsonObj["online"]) {
                            onlineNum++;
                        }

                        //统计CPU
                        if ("Intel" == singleServerJsonObj.CPU) {
                            CPUModelIntelNum++;
                        } else if ("AMD" == singleServerJsonObj.CPU){
                            CPUModelAMDNum++;
                        } else {

                        }

                        //统计状态
                        var memoryUsage =  singleServerJsonObj.usedMemory/singleServerJsonObj.memory;
                        if (memoryUsage<=0.20) {
                            statusFreeNum++;
                        }else if (memoryUsage>=0.80){
                            statusBusyNum++;
                        }else {
                            statusNormalNum++;
                        }

                    }

                }

                //处理数据，生成图表
                var intelPercent =  (CPUModelIntelNum/(CPUModelIntelNum+CPUModelAMDNum)).toFixed(2);
                var amdPercent =  (CPUModelAMDNum/(CPUModelIntelNum+CPUModelAMDNum)).toFixed(2);

                console.log("CPU %:"+intelPercent+" "+amdPercent);

                var data_arr1 = [intelPercent, amdPercent],
                    color_arr1 = ['#F69E00','#36A3B4'],
                    text_arr1 =['Intel', 'AMD'];

                var data_arr2 = [onlineNum/10, offlineNum/10],
                    color_arr2 = ['#35DE1E', '#ED1C24'],
                    text_arr2 =['Online', 'Offline'];

                var data_arr3 = [statusNormalNum/10, statusBusyNum/10, statusFreeNum/10, statusDeadNum/10],
                    color_arr3 = [ '#FFC90E', '#ED1C24', '#00FF21', '#7F7F7F'],
                    text_arr3 =['Normal', 'Busy', 'Free', 'Dead'];

                drawCircle('pei_1', data_arr1, color_arr1, text_arr1);
                drawCircle('pei_2', data_arr2, color_arr2, text_arr2);
                drawCircle('pei_3', data_arr3, color_arr3, text_arr3);

            }else{
                $("#system_message").html("Server internal error");
            }

        },
        error : function (jqXHR) {
            $("#system_message").html("can't connect server:");
        }

    });

    function drawCircle(canvasId, data_arr, color_arr, text_arr){
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
                var percent = text_arr[i] + ' : ' + Math.round(data_arr[i]*100) + '%';
                context.fillText(percent, textX, textY + 20 * i);
            }

        }
    }

});
