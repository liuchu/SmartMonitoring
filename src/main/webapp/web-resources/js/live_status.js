/**
 * Created by no one on 2017/12/28.
 *
 */

$(document).ready(function(){

    function loadData() {

        console.log("loading data");

        $.ajax({
            url : "/serverInfo/latest",
            async : false,
            type:"GET",
            success : function(data,status,jqXHR){
                //alert("status:"+jqXHR.status);

                if(jqXHR.status == 200){
                    var jsonObj = JSON.parse(data); //由JSON字符串转换为JSON对象

                    var jsonArray = jsonObj["response"];

                    var IPList = [];

                    //解析JSON
                    for(ind in jsonArray){

                        var str = jsonArray[ind];

                        var serverInfoObj = JSON.parse(str);

                        var ip = serverInfoObj["IP"];
                        IPList.push(ip);
                        var online = serverInfoObj["online"];

                        if (!online) {
                            $("#tr"+ind).attr("bgcolor","#696969");

                            var tds1 = $("#tr"+ind).find("td");

                            tds1.eq(0).html("<strong style='color: orangered;'>"+serverInfoObj["IP"]+"</strong>");
                            tds1.eq(1).html("<span style='color: orangered;'>Offline</span>");

                            //disable modify button
                            tds1.eq(7).find("button").eq(0).attr("class","disabled btn-default");
                            //tds1.eq(7).find("button").eq(0).unbind();

                            //start up button
                            tds1.eq(8).find("button").eq(0).attr("class","btn-danger status");
                            tds1.eq(8).find("button").eq(0).html("Startup");

                            //var button = tds1.eq(8).find("button").eq(0);
                            //button.click = updateServerConfig(button);

                            //$("#tr"+ind).eq(0).html(serverInfoObj["IP"]);
                        } else {
                            $("#tr"+ind).attr("bgcolor","");

                            var tds2 = $("#tr"+ind).find("td");

                            tds2.eq(0).html("<strong style='color: green;'>"+serverInfoObj["IP"]+"</strong>");
                            tds2.eq(1).html(serverInfoObj["online"]);
                            tds2.eq(2).html(serverInfoObj["CPU"]);

                            if (serverInfoObj["usedCPU"] > 50) {
                                tds2.eq(3).html("<span style='color: orangered;'>"+serverInfoObj["usedCPU"]+"%"+"</span>");
                            } else if (serverInfoObj["usedCPU"] < 20) {
                                tds2.eq(3).html("<span style='color: green;'>"+serverInfoObj["usedCPU"]+"%"+"</span>");
                            }else {
                                tds2.eq(3).html(serverInfoObj["usedCPU"]+"%");
                            }

                            //tds2.eq(3).html(serverInfoObj["usedCPU"]);

                            var cpuUsagePercent = (serverInfoObj["usedMemory"]/serverInfoObj["memory"]).toFixed(2);
                            if (cpuUsagePercent > 0.80) {
                                tds2.eq(4).html("<strong style='color: orangered;'>"+serverInfoObj["usedMemory"]+"</strong>"+"/"+serverInfoObj["memory"]);
                                tds2.eq(6).html("<strong style='color: orangered;'>"+serverInfoObj["currentThreads"]+"</strong>"+"/"+serverInfoObj["maxAllowedThreads"]);
                            } else if (cpuUsagePercent < 0.20) {
                                tds2.eq(4).html("<strong style='color: green;'>"+serverInfoObj["usedMemory"]+"</strong>"+"/"+serverInfoObj["memory"]);
                                tds2.eq(6).html("<strong style='color: green;'>"+serverInfoObj["currentThreads"]+"</strong>"+"/"+serverInfoObj["maxAllowedThreads"]);
                            }else {
                                tds2.eq(4).html("<strong style='color: orange;'>"+serverInfoObj["usedMemory"]+"</strong>"+"/"+serverInfoObj["memory"]);
                                tds2.eq(6).html("<strong style='color: orange;'>"+serverInfoObj["currentThreads"]+"</strong>"+"/"+serverInfoObj["maxAllowedThreads"]);
                            }

                            tds2.eq(5).html("<span style='color: blue;'>"+serverInfoObj["usedDisk"]+"</span>"+"/"+serverInfoObj["disk"]);

                            //modify max threads

                            tds2.eq(7).find("button").eq(0).attr("class","btn-primary threads");

                            //var button1 = tds2.eq(7).find("button").eq(0);
                            //button1.click = updateServerConfig(button1);

                            tds2.eq(8).find("button").eq(0).attr("class"," btn-danger status");
                            tds2.eq(8).find("button").eq(0).html("Shutdown");

                            //tds2.eq(8).find("button").eq(0).onclick = updateServerConfig();

                            //var button2 = tds2.eq(8).find("button").eq(0);
                            //button2.click = updateServerConfig(button2);

                        }

                    }

                }else{
                    $("#system_message_live").html("Server internal error");
                }

            },
            error : function (jqXHR) {
                $("#system_message_live").html("can't connect server:");
            }

        });
        
    }

    //修改最大线程，或起停服务器
    function updateServerConfig(ip,type,value) {

        $.ajax({
            url : "/serverInfo/config",
            data : {
                "ip":ip,
                "type":type,
                "value":value
            },
            async : false,
            type:"POST",
            success : function(data,status,jqXHR){
                //alert("status:"+jqXHR.status);

                if(jqXHR.status == 200){

                    var jsonObj = JSON.parse(data); //由JSON字符串转换为JSON对象

                    if (jsonObj.response == "success") { //不存在 则继续创建

                        alert("操作成功！");
                    }else {
                        alert("操作失败！");
                    }

                }else{
                    alert("内部错误！");
                }

            },
            error : function (jqXHR) {
                alert("服务器连接失败！");
            }

        });

    }

    loadData();

    $(".threads").on("click",function(){
        var buttonText = $(this).text();

        var tds_temp = $(this).parents("tr").eq(0).find("td");

        var ip = tds_temp.eq(0).find("strong").eq(0).text();

        var type = "threads";

        var value = tds_temp.eq(7).find("input").eq(0).val();

        if (value==null) {
            alert("请先输入");
            return;
        }

        updateServerConfig(ip,type,value);

        //alert("ip:"+ip+" type:"+type+ " value:"+value);
    });

    $(".status").on("click",function(){
        var buttonText = $(this).text();

        //console.log("button text:"+buttonText);

        var tds_temp = $(this).parents("tr").eq(0).find("td");

        var ip = tds_temp.eq(0).find("strong").eq(0).text();

        //var status = tds_temp.eq(1).find("strong").eq(0).text();

        var type = "status";

        var value;

        if ("Startup" == buttonText) {
            value = true;
        } else {
            value = false;
        }

        updateServerConfig(ip,type,value);

    });

    window.setInterval(loadData, 5000);

});
