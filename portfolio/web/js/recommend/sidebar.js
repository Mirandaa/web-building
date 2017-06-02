$(document).ready(function(){

    $.post("getTestStatus",null,function (data) {
        var json = JSON.parse(data);
        if(json.isOk){
            $("#b01").click(function(){
                htmlobj=$.ajax({url:"linkpage1.html",async:false});
                $("#myDiv").html(htmlobj.responseText);
                console.log("123456");
                var types = ["谨慎型","稳健型","平衡型","进取型","激进型"];
                var contents =["您属于可以承担低风险而作风谨慎类型的投资者。您适合投资于以保本为主的投资工具，但您因此会牺牲资本升值的机会。",
                    "您属于可以承担低至中等风险类型的投资者。您适合投资于能够权衡保本而亦有若干升值能力的投资工具。",
                    "您属于可以承担中等风险类型的投资者。您适合投资于能够为您提供温和升值能力，而投资价值有温和波动的投资工具。",
                    "您属于可以承担中等至高风险类型的投资者。您适合投资于能够为您提供升值能力，而投资价值有波动的投资工具。",
                    "您属于可以承受高风险类型的投资者。您适合投资于能够为您提供高升值能力而投资价值波动大的投资工具。最坏的情况下，您可能失去全部投资本金并需对您投资所导致的任何亏蚀承担责任。"];
                var abilitys = ["低","中偏低","中","中偏高","高"];
                var expects = ["较低收益","中等偏低收益","中等收益","中等偏高收益","高收益"];
                var suggests = ["二级市场：20%，固定收益：45%，海外资产：10%，现金管理：25%",
                    "二级市场：15%，中长期股权：10%，固定收益：45%，海外资产：10%，现金管理：20%",
                    "二级市场：15%，中长期股权：20%，固定收益：40%，海外资产：10%，现金管理：15%",
                    "二级市场：20%，中长期股权：25%，固定收益：35%，海外资产：10%，现金管理：10%",
                    "二级市场：25%，中长期股权：30%，固定收益：30%，海外资产：10%，现金管理：5%"];
                var temp = json.ability - 1;
                var a = $("#score");
                if(a == null){
                    console.log("111111111");
                }
                $("#score").text(json.score);
                $("#type").text(types[temp]);
                $("#content").text(contents[temp]);
                $("#ability").text(abilitys[temp]);
                $("#except").text(expects[temp]);
                $("#suggest").text(suggests[temp]);
                console.log("654321");
            });

        }
        else {
            $("#b01").click(function(){
                htmlobj=$.ajax({url:"linkpage1_untest.html",async:false});
                $("#myDiv").html(htmlobj.responseText);
            });
        }
        $("#b01").click();


    });

    $("#b02").click(function(){
        htmlobj=$.ajax({url:"linkpage2.html",async:false});
        $("#myDiv").html(htmlobj.responseText);
    });

	$("ul li").click(function() {
		$(this).children("a").addClass("active");
		if($(this).siblings("li").children("a").hasClass("active")) {
			$(this).siblings("li").children("a").removeClass("active");
		}
	});
});