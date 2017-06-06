/**
 * Created by p on 2017/6/2.
 */
//判断登录状态
function setStatus() {
    $.post("getStatus",null,function (data) {
        var res = JSON.parse(data);
        if(res.isOk){
            $("#sign").html("<a href='#' onclick='sign_out()'>" + res.name + "/退出登录</a>");
            $("#recommend").html("<a href='project.html'>"  + "组合推荐</a>");
            $("#name").text(res.name);
        }
        else {
            $("#sign").html("<a href='sign_in.html'>登录／注册</a>");
            $("#recommend").html("<a href='project_unlog.html'>"  + "组合推荐</a>");
            $("#name").text("用户名");
        }
    });
}

function getNews() {
    $.post("getNews",null,function (data) {
        for(var i = 0; i < data.length; i++){
            console.log(data[i].title);
            switch (i){
                case 0:$(".news1_title").html("<a href = \"" + data[i].link + "\">" + data[i].title + "</a>");
                    $(".news1_des").text(data[i].des);
                    break;
                case 1:$(".news2_title").html("<a href = \"" + data[i].link + "\">" + data[i].title + "</a>");
                    $(".news2_des").text(data[i].des);
                    break;
                case 2:$(".news3_title").html("<a href = \"" + data[i].link + "\">" + data[i].title + "</a>");
                    $(".news3_des").text(data[i].des);
                    break;
                case 3:$(".news4_title").html("<a href = \"" + data[i].link + "\">" + data[i].title + "</a>");
                    $(".news4_des").text(data[i].des);
                    break;
                case 4:$(".news5_title").html("<a href = \"" + data[i].link + "\">" + data[i].title + "</a>");
                    $(".news5_des").text(data[i].des);
                    break;
            }


        }
    });
}

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
                "<div> " +
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
                temp = temp.replace("4.3",res.list[i].yearRate);
                content += temp;
            }
            $("#groupContent").html(content);
        }
    });
}