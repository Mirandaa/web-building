/**
 * Created by p on 2017/5/4.
 */
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