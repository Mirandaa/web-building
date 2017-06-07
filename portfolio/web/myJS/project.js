/**
 * Created by p on 2017/6/6.
 */
function getGroups() {
    $.post("getGroups",null,function (data) {
        var res = JSON.parse(data);
        if(res.isOk){
            var con = "<div class='col-md'> " +
                "<div class='default-blog-news wow fadeInUp animated' style='visibility: visible; animation-name: fadeInUp;'> " +
                "<div class='lower-content'> " +
                "<h4><a href='#'>安心计划 I-201701209</a></h4> " +
                "<div class='post-meta'>保守型  |  起投天数：30天</div> " +
                "<div class='text'> " +
                "<p>起投金额：100元</p> " +
                "<p>预计年化利率：<strong>4.3%</strong></p> " +
                "</div><div> " +
                "<a href='#' class='default_link'>了解详情</a> " +
                "</div> " +
                "</div> " +
                "</div> " +
                "</div>";
            var types = ["谨慎型","稳健型","平衡型","进取型","激进型"];
            var content = "";
            for(var i = 0; i < res.count; i++){
                console.log(res.list[i]);
                var x = res.list[i].type;
                console.log(x);
                var temp = con.replace("安心计划 I-201701209",res.list[i].name);
                temp = temp.replace("保守型",types[x - 1]);
                temp = temp.replace("起投天数：30天","起投天数：" + res.list[i].days + "天");
                temp = temp.replace("起投金额：100元","起投金额：" + res.list[i].minMoney + "元")
                temp = temp.replace("4.3",res.list[i].yearRate.toFixed(2));
                content += temp;
            }
            $("#groupContent").html(content);
        }
    });
}

function submit() {
    var info = {};
    info["day"] = $("#day").val();
    info["money"] = $("#single").val();
    $.post("group",info,function (data) {
        var res = JSON.parse(data);
        if(res.isOk){
            if(res.count > 0){
                var con = "<div class='col-md'> " +
                    "<div class='default-blog-news wow fadeInUp animated' style='visibility: visible; animation-name: fadeInUp;'> " +
                    "<div class='lower-content'> " +
                    "<h4><a href='#'>安心计划 I-201701209</a></h4> " +
                    "<div class='post-meta'>保守型  |  起投天数：30天</div> " +
                    "<div class='text'> " +
                    "<p>起投金额：100元</p> " +
                    "<p>预计年化利率：<strong>4.3%</strong></p> " +
                    "</div><div> " +
                    "<a href='#' class='default_link'>了解详情</a> " +
                    "</div> " +
                    "</div> " +
                    "</div> " +
                    "</div>";
                var types = ["谨慎型","稳健型","平衡型","进取型","激进型"];
                var content = "";
                for(var i = 0; i < res.count; i++){
                    console.log(res.list[i]);
                    var x = res.list[i].type;
                    console.log(x);
                    var temp = con.replace("安心计划 I-201701209",res.list[i].name);
                    temp = temp.replace("保守型",types[x - 1]);
                    temp = temp.replace("起投天数：30天","起投天数：" + res.list[i].days + "天");
                    temp = temp.replace("起投金额：100元","起投金额：" + res.list[i].minMoney + "元")
                    temp = temp.replace("4.3",res.list[i].yearRate.toFixed(2));
                    content += temp;
                }
                $("#groupContent").html(content);
            }
            else {
                alert("抱歉，暂时无适合您的产品");
                getGroups();
            }
        }
        else {
            alert("抱歉，发生了一些未知错误，请重试");
            getGroups();
        }
    })
}