/**
 * Created by no one on 2017/12/24.
 *
 */
$(document).ready(function(){

    console.log("Loading charts");

    //重新加载图表
    function loadChart(ip,type) {
        
    }

    var lineChartData = {
        labels : ["Dec-1","Dec-2","Dec-3","Dec-5","Dec-6","Dec-7","Dec-8","Dec-9","Dec-10"],
        datasets : [
            {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                data : [0,0,90,81,56,55,40,99,67,12]
            }
        ]

    };

    var myLine1 = new Chart(document.getElementById("line_chart_cpu").getContext("2d")).Line(lineChartData);
    var myLine2 = new Chart(document.getElementById("line_chart_memory").getContext("2d")).Line(lineChartData);
    var myLine3 = new Chart(document.getElementById("line_chart_thread").getContext("2d")).Line(lineChartData);
    var myLine4 = new Chart(document.getElementById("line_chart_disk").getContext("2d")).Line(lineChartData);

    /*myLine1 = new Chart(document.getElementById("line_chart_cpu").getContext("2d")).Bar(lineChartData);
     myLine2 = new Chart(document.getElementById("line_chart_memory").getContext("2d")).Bar(lineChartData);
     myLine3 = new Chart(document.getElementById("line_chart_thread").getContext("2d")).Bar(lineChartData);
     myLine4 = new Chart(document.getElementById("line_chart_disk").getContext("2d")).Bar(lineChartData);*/

    $("#select_language_submit").attr("href","/setting/changeLanguage?lang="+"en_US");

    //获取Select的值，并拼接到方法里
    $("#select_language").change(
        function () {

            var language = $("#select_language").val();
            var language_code = '';

            switch (language) {
                case "English": language_code = "en_US";
                    break;
                case "中文": language_code = "zh_CN";
                    break;
                default : language_code = "en_US";
                    break;
            }

            $("#select_language_submit").attr("href","/setting/changeLanguage?lang="+language_code);
        }
    );

});