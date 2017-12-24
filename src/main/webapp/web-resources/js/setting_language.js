/**
 * Created by one on on 2017/12/24.
 *
 */
$(document).ready(function(){

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