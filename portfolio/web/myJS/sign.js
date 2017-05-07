/**
 * Created by p on 2017/3/9.
 */
function sign_in() {
    var user_json = {};
    user_json["name"] = $("#sign_in_user").val();
    user_json["psw"] = $("#sign_in_pass").val();
    $.post("/portfolio/signIn",user_json,function (data) {
        var ret = JSON.parse(data);
        if(ret.res){
            window.location.href = "index.jsp";
        }
        else {
            alert(ret.msg)
        }
    });
}
function sign_up() {
    $("#sign_up_user_label").html("用户名");
    $("#sign_up_pass_label").html("输入密码");
    $("#sign_up_verify_pass_label").html("再次输入密码");
    $("#sign_up_email_label").html("邮箱");
    var user_info = {}

    user_info["name"] = $("#sign_up_user").val();
    if (user_info["name"] == ""){
        $("#sign_up_user_label").html("用户名(必填)");
        return;
    }

    user_info["email"] = $("#sign_up_email").val();
    if (user_info["email"] == ""){
        $("#sign_up_email_label").html("邮箱(必填)");
        return;
    }
    else {
        var reg = /^\w+((-\w+)|(\.\w+))*@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        var isok= reg.test(user_info["email"]);
        if (!isok) {
            $("#sign_up_email_label").html("邮箱(格式不正确)");
            return;
        }
    };

    var psw = $("#sign_up_pass").val();
    if (psw == ""){
        $("#sign_up_pass_label").html("输入密码(必填)");
        return;
    }
    if(psw.length < 6){
        $("#sign_up_pass_label").html("输入密码(至少6位)");
        return;
    }

    var psw_verify = $("#sign_up_verify_pass").val();
    if (psw_verify == ""){
        $("#sign_up_verify_pass_label").html("再次输入密码(必填)");
        return;
    }
    if (psw == psw_verify){
        user_info["psw"] = psw;
        $.post("signUp",user_info,function (data) {
            var ret = JSON.parse(data);
            if(ret.res){
                if (confirm("注册成功，跳转登录界面"))
                    window.location.href = "sign_in.html";
            }
            else {
                alert(ret.msg)
            }
        })
    }
    else {
        $("#sign_up_verify_pass_label").html("再次输入密码(两次密码不匹配)");
        return;
    }

}

function sign_out() {
    if (confirm("确认退出？")) {
        $.post("signOut", "", function (data) {
            alert("退出成功");
            window.location.href = "index.jsp";
        });
    }
}