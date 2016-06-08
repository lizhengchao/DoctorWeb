/**
 * Created by lzc on 2016/6/6.
 */
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/user/haslogin.do",
        type: "GET",
        success: function(data){
            //用户已登录则修改导航栏内容
            if(data.success){
                userId = data.data.id;
                userName = data.data.nickname;
                sessionStorage.setItem("userId", data.data.id);
                sessionStorage.setItem("userName", data.data.nickname);
                sessionStorage.setItem("residentId", data.data.resDocId);
                $('#nameLi').text(userName);
                $('#loginLi').css("display","none");
                $('#registerLi').css("display","none");
                $('#serviceLi').css("display","block");
                $('#infoLi').css("display","block");
                $('#logoutLi').css("display","block");
                $('nickname').val(userName);
            }
        }
    })
})


function logout(){
    $.ajax({
        url: "http://localhost:8080/user/logout.do?",
        type: "GET",
        success: function(data){
            if(data.success){
                sessionStorage.removeItem("userId");
                sessionStorage.removeItem("userName");
                sessionStorage.removeItem("residentId");
                window.location = "../resident-index.html"

            } else {
                alert(data.message);
            }
        }
    })
}