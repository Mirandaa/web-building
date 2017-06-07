/**
 * Created by p on 2017/5/7.
 */

function test_check_submit() {
    var info = {};
    var names = ["age", "health", "experience", "purpose", "rate", "date", "down", "spending", "state", "retire"];
    var x = "input:radio[name='age']:checked";
    for (var i = 0; i < names.length; i++) {
        x = "input:radio[name='" + names[i] + "']:checked";
        var value = $(x).val();
        var temp = i + 1;
        if (value != undefined) {
            info[temp + ""] = value;
        }
        else {
            alert("第" + temp + "题未选择");
            return;
        }
    }

    $.post("testCheck", info, function (data) {
        var ret = JSON.parse(data);
        if(ret.isOk){
            window.location.href = "project.html";
        }
        else {
            alert(ret.msg);
        };

    });
}