/**
 * Created by p on 2017/3/9.
 */
function sign_in() {
    var user_json = {};
    user_json["name"] = $("#sign_in_user").val();
    user_json["psw"] = $("#sign_in_pass").val();
    $.post("/sign_in",user_json,function (data) {
        alert(data);
    });
}
function sign_up() {
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
    if (user_info["email"].indexOf("@") <= 0){
        $("#sign_up_email_label").html("邮箱(格式不正确)");
        return;
    }
    var psw = $("#sign_up_pass").val();
    if (psw == ""){
        $("#sign_up_pass_label").html("输入密码(必填)");
        return;
    }
    var psw_verify = $("#sign_up_verify_pass").val();
    if (psw_verify == ""){
        $("#sign_up_verify_pass_label").html("再次输入密码(必填)");
        return;
    }
    if (psw == psw_verify){
        user_info["psw"] = psw;
        $.post("/sign_up",user_info,function (data) {
            alert(data);
        })
    }
    else {
        $("#sign_up_verify_pass_label").html("再次输入密码(必填)(两次密码不匹配)");
        return;
    }

}