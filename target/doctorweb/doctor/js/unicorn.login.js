/**
 * Unicorn Admin Template
 * Diablo9983 -> diablo9983@gmail.com
**/
$(document).ready(function(){

	var login = $('#loginform');
	var recover = $('#recoverform');
	var speed = 400;

	$('#to-recover').click(function(){
		login.fadeTo(speed,0.01).css('z-index','100');
		recover.fadeTo(speed,1).css('z-index','200');
	});

	$('#to-login').click(function(){
		recover.fadeTo(speed,0.01).css('z-index','100');
		login.fadeTo(speed,1).css('z-index','200');
	});

    if($.browser.msie == true && $.browser.version.slice(0,3) < 10) {
        $('input[placeholder]').each(function(){

        var input = $(this);

        $(input).val(input.attr('placeholder'));

        $(input).focus(function(){
             if (input.val() == input.attr('placeholder')) {
                 input.val('');
             }
        });

        $(input).blur(function(){
            if (input.val() == '' || input.val() == input.attr('placeholder')) {
                input.val(input.attr('placeholder'));
            }
        });
    });
    }

    $('#loginbutton').click(function(){

        var username = $('#username').val();
        if(username == "") {
            $('#loginwarn').text("用户名为空");
            return;
        }
        var password = $('#password').val();
        if(password == "") {
            $('#loginwarn').text("密码为空");
            return;
        }
        var type = $('#type').val();
        $.ajax({
            url:"http://localhost:8080/user/login.do?userType="+type+"&nickname="+username+"&password="+password,
            success:function(data){
                if(data.success==true){
                    sessionStorage.setItem("username",username);
                    sessionStorage.setItem("usertype",type);
                    sessionStorage.setItem("doctorId",data.data.resDocId);
                    sessionStorage.setItem("comhisid",data.data.comhisid);
                    sessionStorage.setItem("comhisname", data.data.comhisname);
                    if(type == 1) {
                        window.location = "./index.html";
                    }
                    if(type == 0) {
                        window.location = "./manage-index.html"
                    }
                }
                else{
                    $('#loginwarn').text(data.message);
                }
            }
          });
    });
});