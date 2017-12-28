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
                    console.log("200:"+data);
                    var jsonObj = JSON.parse(data); //由JSON字符串转换为JSON对象

                    var jsonArray = jsonObj["response"];

                    //console.log(JSON.stringify(jsonArray));

                    var table = $("#live_status_tbody");

                    //解析JSON
                    for(ind in jsonArray){

                        //console.log("foreach:"+ind);

                        var str = jsonArray[ind];

                        //console.log(str);

                        var serverInfoObj = JSON.parse(str);

                        //console.log(JSON.stringify(serverInfoObj));

                        var ip = serverInfoObj["IP"];
                        var online = serverInfoObj["online"];

                        if (!online) {
                            $("#tr"+ind).attr("bgcolor","#696969");
                            $("#tr"+ind).eq(0).html(serverInfoObj["IP"]);
                        } else {
                            //console.log($("#tr"+ind));
                            $("#tr"+ind).attr("bgcolor","");
                            var tds = $("#tr"+ind).find("td");

                            tds.eq(0).html(serverInfoObj["IP"]);
                            tds.eq(1).html(serverInfoObj["online"]);
                            tds.eq(2).html(serverInfoObj["CPU"]);
                            tds.eq(3).html(serverInfoObj["usedCPU"]);
                            tds.eq(4).html(serverInfoObj["usedMemory"]+"/"+serverInfoObj["memory"]);
                            tds.eq(5).html(serverInfoObj["usedDisk"]+"/"+serverInfoObj["disk"]);
                            tds.eq(6).html(serverInfoObj["currentThreads"]+"/"+serverInfoObj["maxAllowedThreads"]);

                            console.log("END");
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

    loadData();

    window.setInterval(loadData, 5000);

});
