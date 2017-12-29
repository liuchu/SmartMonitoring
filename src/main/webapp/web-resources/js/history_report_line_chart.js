/**
 * Created by no one on 2017/12/24.
 *
 */
$(document).ready(function(){

    $("#chart_submit").on("click",function () {
        var date = $("#chart_date").val();
        var ip = $("#select_ip").val();
        console.log("submit! ip"+ip+" date"+date);

        loadChart(ip,date);
    });

    //console.log("Loading charts");
    //重新加载图表
    function loadChart(ip,date) {

        $("#selectedIP").html(ip);
        $("#selectedDate").html(date);

        $.ajax({
            url : "/serverInfo/history",
            async : false,
            data : {
                "ip":ip,
                "date":date
            },
            type :"GET",
            success : function(data,status,jqXHR){

                if(jqXHR.status == 200){

                    //console.log(data);

                    var chartDataCPU1 = {};
                    var chartDataMemory1 = {};
                    var chartDataDisk1 = {};
                    var chartDataThreads1 = {};

                    var commonLabel = ["0","1","2","3","4","5","6",
                        "7","8","9","10","11","12",
                        "13","14","15","16","17","18",
                        "19","20","21","22","23"
                    ];

                    chartDataCPU1["labels"] = commonLabel;
                    chartDataMemory1["labels"] = commonLabel;
                    chartDataDisk1["labels"] = commonLabel;
                    chartDataThreads1["labels"] = commonLabel;

                    var arrayElementsCPU = [];
                    var arrayElementsMemory = [];
                    var arrayElementsDisk = [];
                    var arrayElementsThreads = [];

                    var arrayTempCPU = [];
                    var arrayTempMemory = [];
                    var arrayTempDisk = [];
                    var arrayTempThreads = [];

                    var jsonObj = JSON.parse(data); //由JSON字符串转换为JSON对象

                    var jsonArrayInfoAtDay =  jsonObj[ip];

                    //console.log(JSON.stringify(jsonArrayInfoAtDay));

                    for(index in jsonArrayInfoAtDay){

                        var jsonInfoAtHour = jsonArrayInfoAtDay[index];

                        var key = parseInt(1)+parseInt(index);
                        var jsonInfoAtHourKey = key.toString();

                        var jsonInfoAtHourValue = jsonInfoAtHour[jsonInfoAtHourKey];

                        var usedCPU = jsonInfoAtHourValue["usedCPU"];
                        var usedMemory = jsonInfoAtHourValue["usedMemory"];
                        var usedDisk = jsonInfoAtHourValue["usedDisk"];
                        var currentThreads = jsonInfoAtHourValue["currentThreads"];

                        //console.log(ip+"cpu is:"+usedCPU);

                        arrayTempCPU.push(usedCPU);
                        arrayTempMemory.push(usedMemory);
                        arrayTempDisk.push(usedDisk);
                        arrayTempThreads.push(currentThreads);

                    }

                    var elementCPU = {};
                    elementCPU["fillColor"] = "rgba(220,220,220,0.5)";
                    elementCPU["strokeColor"] = "rgba(243,27,35,1)";
                    elementCPU["pointColor"] = "rgba(220,220,220,1)";
                    elementCPU["pointStrokeColor"] = "#64ff4a";
                    elementCPU["data"] = arrayTempCPU;

                    var elementMemory = {};
                    elementMemory["fillColor"] = "rgba(220,220,220,0.5)";
                    elementMemory["strokeColor"] = "rgba(243,27,35,1)";
                    elementMemory["pointColor"] = "rgba(220,220,220,1)";
                    elementMemory["pointStrokeColor"] = "#64ff4a";
                    elementMemory["data"] = arrayTempMemory;

                    var elementDisk = {};
                    elementDisk["fillColor"] = "rgba(220,220,220,0.5)";
                    elementDisk["strokeColor"] = "rgba(243,27,35,1)";
                    elementDisk["pointColor"] = "rgba(220,220,220,1)";
                    elementDisk["pointStrokeColor"] = "#64ff4a";
                    elementDisk["data"] = arrayTempDisk;

                    var elementThreads = {};
                    elementThreads["fillColor"] = "rgba(220,220,220,0.5)";
                    elementThreads["strokeColor"] = "rgba(243,27,35,1)";
                    elementThreads["pointColor"] = "rgba(220,220,220,1)";
                    elementThreads["pointStrokeColor"] = "#64ff4a";
                    elementThreads["data"] = arrayTempThreads;

                    arrayElementsCPU.push(elementCPU);
                    arrayElementsMemory.push(elementMemory);
                    arrayElementsDisk.push(elementDisk);
                    arrayElementsThreads.push(elementThreads);

                    chartDataCPU1["datasets"] = arrayElementsCPU;
                    chartDataMemory1["datasets"] = arrayElementsMemory;
                    chartDataDisk1["datasets"] = arrayElementsDisk;
                    chartDataThreads1["datasets"] = arrayElementsThreads;

                    //console.log("Response from server:"+data);

                    var myLine1 = new Chart(document.getElementById("line_chart_cpu").getContext("2d")).Line(chartDataCPU1);
                    var myLine2 = new Chart(document.getElementById("line_chart_memory").getContext("2d")).Line(chartDataMemory1);
                    var myLine3 = new Chart(document.getElementById("line_chart_thread").getContext("2d")).Line(chartDataDisk1);
                    var myLine4 = new Chart(document.getElementById("line_chart_disk").getContext("2d")).Line(chartDataThreads1);

                    var myBar1 = new Chart(document.getElementById("bar_chart_cpu").getContext("2d")).Bar(chartDataCPU1);
                    var myBar2 = new Chart(document.getElementById("bar_chart_memory").getContext("2d")).Bar(chartDataMemory1);
                    var myBar3 = new Chart(document.getElementById("bar_chart_thread").getContext("2d")).Bar(chartDataDisk1);
                    var myBar4 = new Chart(document.getElementById("bar_chart_disk").getContext("2d")).Bar(chartDataThreads1);

                }else{
                    $("#system_message_dashboard").html("Server internal error");
                }

            },
            error : function (jqXHR) {
                $("#system_message_dashboard").html("can't connect server:");
            }

        });
    }

    var date = new Date();
    var dateStr =  date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
    //console.log("Today:"+dateStr);

    loadChart("211.211.211.101",dateStr);


});