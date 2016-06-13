/**
 * Created by lzc on 2016/6/8.
 */

function logout(){
    $.ajax({
        url: "http://localhost:8080/user/logout.do?",
        type: "GET",
        success: function(data){
            if(data.success){
                sessionStorage.removeItem("username");
                sessionStorage.removeItem("usertype");
                sessionStorage.removeItem("doctorId");
                sessionStorage.removeItem("comHosId");
                sessionStorage.removeItem("comHosName");
                window.location = "./login.html"

            } else {
                alert(data.message);
            }
        }
    })
}

$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/user/haslogin.do",
        type: "GET",
        success: function(data){
            //用户已登录则修改导航栏内容
            if(data.success){
                $('#userName').text("hi! "+sessionStorage.getItem("username"));
            } else {
                window.location = "./login.html";
            }
        }
    })
})