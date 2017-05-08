﻿<%@ page import="entity.UserInfoEntity" %>
<!DOCTYPE html>
<html lang="en">
<%UserInfoEntity user = (UserInfoEntity) session.getAttribute("user");%>
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="favicon.ico">
    <title>组财｜为您打造最优投资方案</title> 

    <!-- mobile responsive meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/jquery.circliful.css">

</head>
<body>

<div class="boxed_wrapper">

<section class="theme_menu stricky">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="main-logo">
                    <a href="index.jsp"><img src="images/logo/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-md-8 menu-column">
                <nav class="menuzord" id="main_menu">
                   <ul class="menuzord-menu">
                        <li class="active"><a href="index.jsp">首页</a></li>
												<li><a href="about.html">新手指引</a></li>
                        <li><a href="service.html">组合排行榜</a></li>
												<li><a href="project.html">组合推荐</a></li>
												<li><a href="shop.html">股票行情</a></li>
                        <li><%if (user == null){%>
                            <a href="sign_in.html">登录／注册</a>
                            <%}else {%>
                            <a onclick="sign_out()" ><%=user.getName()%>／退出登录</a>
                            <%}%></li>
                    </ul><!-- End of .menuzord-menu -->
                </nav> <!-- End of #main_menu -->
            </div>
            <div class="right-column">
                <div class="right-area">
                    <div class="nav_side_content">
                        <div class="search_option">
                            <button class="search tran3s dropdown-toggle color1_bg" id="searchDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-search" aria-hidden="true"></i></button>
                            <form action="#" class="dropdown-menu" aria-labelledby="searchDropdown">
                                <input type="text" placeholder="Search...">
                                <button><i class="fa fa-search" aria-hidden="true"></i></button>
                            </form>
                       </div>
                   </div>
                </div>
                    
            </div>
        </div>
                

   </div> <!-- End of .conatiner -->
</section>
  
<section class="rev_slider_wrapper">
    <div id="slider1" class="rev_slider"  data-version="5.0">
        <ul>
            
            <li data-transition="fade">
                <img src="images/slider/1.jpg"  alt="" width="1920" height="683" data-bgposition="top center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="1" >
                
                <div class="tp-caption tp-resizeme"
                    data-x="right" data-hoffset="0" 
                    data-y="center" data-voffset="0" 
                    data-transform_idle="o:1;"         
                    data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0.01;s:1500;e:Power3.easeOut;" 
                    data-transform_out="s:500;e:Power3.easeInOut;s:500;e:Power3.easeInOut;" 
                    data-mask_in="x:[100%];y:0;s:inherit;e:inherit;" 
                    data-splitin="none" 
                    data-splitout="none"  
                    data-responsive_offset="on"
                    data-start="500">
                    <div class="slide-content-box">
                        <h1>选择困难？对理财、投资疑惑？<br>那么欢迎来到组财</h1>
                        <p>随需而变，针对百姓的友好理财推荐网站<br>根据您的需求，为您推荐合适的理财组合</p>
                    </div>
                </div>
            </li>
            <li data-transition="fade">
                <img src="images/slider/2.jpg"  alt="" width="1920" height="683" data-bgposition="top center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="1" >
                
                <div class="tp-caption tp-resizeme" 
                    data-x="center" data-hoffset="0" 
                    data-y="center" data-voffset="-60" 
                    data-transform_idle="o:1;"                         
                    data-transform_in="y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;s:1500;e:Power4.easeInOut;" 
                    data-transform_out="s:500;e:Power3.easeInOut;s:500;e:Power3.easeInOut;"                     
                    data-splitin="none" 
                    data-splitout="none" 
                    data-responsive_offset="on"
                    data-start="100">
                </div>
                <div class="tp-caption tp-resizeme"
                    data-x="center" data-hoffset="" 
                    data-y="center" data-voffset="30" 
                    data-transform_idle="o:1;"         
                    data-transform_in="x:[-175%];y:0px;z:0;rX:0;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0.01;s:1500;e:Power3.easeOut;" 
                    data-transform_out="s:500;e:Power3.easeInOut;s:500;e:Power3.easeInOut;" 
                    data-mask_in="x:[100%];y:0;s:inherit;e:inherit;" 
                    data-splitin="none" 
                    data-splitout="none"  
                    data-responsive_offset="on"
                    data-start="500">
                    <div class="slide-content-box center">
                        <h1>一站式打造投资组合</h1>
                        <p>解决选择困难症<br>为百姓而生的免费设计投资组合平台</p>
                    </div>
                </div>
                <div class="tp-caption tp-resizeme" 
                    data-x="center" data-hoffset="0" 
                    data-y="center" data-voffset="160" 
                    data-transform_idle="o:1;"                         
                    data-transform_in="y:[100%];z:0;rX:0deg;rY:0;rZ:0;sX:1;sY:1;skX:0;skY:0;opacity:0;s:1500;e:Power4.easeInOut;" 
                    data-transform_out="s:500;e:Power3.easeInOut;s:500;e:Power3.easeInOut;"                     
                    data-splitin="none" 
                    data-splitout="none" 
                    data-responsive_offset="on"
                    data-start="1500">
                </div>

            </li>
        </ul>
    </div>
</section>

<section class="whychoos-us sec-padd2">
    <div class="container">
        
        <div class="section-title1 center">
            <h2>为什么选择组财？</h2>
        </div>    
        
        <div class="row clearfix">
            <!--Featured Service -->
            <article class="column col-md-4 col-sm-6 col-xs-12">
                <div class="item">
                    <div class="icon_box">
                        <span class="icon-graphic2"></span>
                    </div>
                    <a href="#"><h4>免费测评风险</h4></a>
                    <div class="text">
                        <p>在保证不泄漏您的信息的情况下<br>可为您免费测评您的投资风险</p>
                    </div>
                    <div class="count">01</div>
                </div>
            </article>
            <!--Featured Service -->
            <article class="column col-md-4 col-sm-6 col-xs-12">
                <div class="item">
                    <div class="icon_box">
                        <span class="icon-layers"></span>
                    </div>
                    <a href="#"><h4>投资组合智能推荐</h4></a>
                    <div class="text">
                        <p>根据您填写的风险测评信息<br>为您推荐最适合您的投资组合</p>
                    </div>
                    <div class="count">02</div>
                </div>
            </article>
            <!--Featured Service -->
            <article class="column col-md-4 col-sm-6 col-xs-12">
                <div class="item">
                    <div class="icon_box">
                        <span class="icon-computer"></span>
                    </div>
                    <a href="#"><h4>提供新闻资讯</h4></a>
                    <div class="text">
                        <p>您可以通过热门新闻资讯<br>更全面地了解最新金融信息</p>
                    </div>
                    <div class="count">03</div>
                </div>
            </article>
            
        </div>
            
    </div>
</section>

<section class="service sec-padd2">
    <div class="container">
        
        <div class="section-title2">
            <h2>您了解它们吗？</h2>
        </div>
        
        <div class="service_carousel">
            <!--Featured Service -->
            <article class="single-column">
                <div class="item">
                    <figure class="img-box">
                        <img src="images/product/1.jpg" alt="">
                        <figcaption class="default-overlay-outer">
                            <div class="inner">
                                <div class="content-layer">
                                    <a href="http://baike.baidu.com/link?url=XzMpW94erLYJU2cTVcJVXhbRhrlNO1FVm8-qqLEUrrV_ZOQ6MsoI1wgzr--tQJvMqu8JU-SAKPhJMEuf2Q2thvb9mcvGmsh0BIGeHu7RfujQj2S5v-ylNnWVicH25PXJ" class="thm-btn thm-tran-bg" target="_blank">查看更多</a>
                                </div>
                            </div>
                        </figcaption>
                    </figure>
                    <div class="content center">
                        <h5>1</h5>
                        <a href="http://baike.baidu.com/link?url=XzMpW94erLYJU2cTVcJVXhbRhrlNO1FVm8-qqLEUrrV_ZOQ6MsoI1wgzr--tQJvMqu8JU-SAKPhJMEuf2Q2thvb9mcvGmsh0BIGeHu7RfujQj2S5v-ylNnWVicH25PXJ" target="_blank"><h4>理财产品</h4></a>
                        <div class="text">
                            <p>由商业银行和正规金融机构<br>自行设计并发行，将募集到的资金根据产品合同约定投入相关金融市场及购买相关金融产品，<br>获取投资收益后，根据合同约定分配给投资人的一类理财产品</p>
                        </div>
                    </div>
                </div>
            </article>
            <!--Featured Service -->
            <article class="single-column">
                <div class="item">
                    <figure class="img-box">
                        <img src="images/product/2.jpg" alt="">
                        <figcaption class="default-overlay-outer">
                            <div class="inner">
                                <div class="content-layer">
                                    <a href="http://baike.baidu.com/item/%E8%82%A1%E7%A5%A8/22647" class="thm-btn thm-tran-bg" target="_blank">查看更多</a>
                                </div>
                            </div>
                        </figcaption>
                    </figure>
                    <div class="content center">
                        <h5>2</h5>
                        <a href="http://baike.baidu.com/item/%E8%82%A1%E7%A5%A8/22647" target="_blank"><h4>股票</h4></a>
                        <div class="text">
                            <p>是股份公司发行的所有权凭证，<br>是股份公司为筹集资金而发行给各个股东作为持股凭证并借以取得股息和红利的一种有价证券</p>
                        </div>
                    </div>
                </div>
            </article>
            <!--Featured Service -->
            <article class="single-column">
                <div class="item">
                    <figure class="img-box">
                        <img src="images/product/3.jpg" alt="">
                        <figcaption class="default-overlay-outer">
                            <div class="inner">
                                <div class="content-layer">
                                    <a href="http://baike.baidu.com/item/%E5%9F%BA%E9%87%91" class="thm-btn thm-tran-bg" target="_blank">查看更多</a>
                                </div>
                            </div>
                        </figcaption>
                    </figure>
                    <div class="content center">
                        <h5>3</h5>
                        <a href="http://baike.baidu.com/item/%E5%9F%BA%E9%87%91" target="_blank"><h4>基金</h4></a>
                        <div class="text">
                            <p>从广义上说，基金是指为了某种目的而设立的具有一定数量的资金。主要包括信托投资基金、公积金、保险基金、退休基金，各种基金会的基金。人们平常所说的基金主要是指证券投资基金。</p>
                        </div>
                    </div>
                </div>
            </article>
            <!--Featured Service -->
            <article class="single-column">
                <div class="item">
                    <figure class="img-box">
                        <img src="images/product/4.jpg" alt="">
                        <figcaption class="default-overlay-outer">
                            <div class="inner">
                                <div class="content-layer">
                                    <a href="http://baike.baidu.com/link?url=JAJC9Mj-y1FI937dZOq9-cmp1aPqwV9LexuLtqiydiANxIE4VCe38Roh71SBFDGYkzxDlIkzVQ3YeuS6Y5KRLYzW8Sp9QYq53KYUWI3a6ZK" class="thm-btn thm-tran-bg" target="_blank">查看更多</a>
                                </div>
                            </div>
                        </figcaption>
                    </figure>
                    <div class="content center">
                        <h5>4</h5>
                        <a href="http://baike.baidu.com/link?url=JAJC9Mj-y1FI937dZOq9-cmp1aPqwV9LexuLtqiydiANxIE4VCe38Roh71SBFDGYkzxDlIkzVQ3YeuS6Y5KRLYzW8Sp9QYq53KYUWI3a6ZK" target="_blank"><h4>保险</h4></a>
                        <div class="text">
                            <p>本意是稳妥可靠保障；后延伸成一种保障机制，是用来规划人生财务的一种工具，是市场经济条件下风险管理的基本手段，是金融体系和社会保障体系的重要的支柱。</p>
                        </div>
                    </div>
                </div>
            </article>
            
        </div>
            
    </div>
</section>

<div class="container"><div class="border-bottom"></div></div>

<section class="news-section sec-padd">
    <div class="container">
        <div class="section-title3 center">
            <h2>新闻资讯</h2>
            <p>实时更新<br>关于金融 经济 股市的要闻</p>
        </div> 
        
        <!--Slider-->      
        <div class="testimonials-slider column-carousel three-column">
            
            <!--Slide-->
            <article class="slide-item">
                <div class="quote"><span class="icon-left"></span></div>
                <div class="author">
                    <h4 class="news1_title">孙宏斌：乐视汽车贾跃亭该怎么弄怎么弄，其他的该卖的卖掉</h4>
                </div>
                
                <div class="slide-text">
                    <p id="control-textview" class="news1_des">【孙宏斌：乐视汽车贾跃亭该怎么弄怎么弄 其他的该卖的卖掉】对于乐视非上市体系，诸如乐视体育、易到等，孙宏斌秉持的原则是“该卖的卖，该合作的合作”。乐视体育方面，孙宏斌强调，“中超去年13亿5一共收了五千万，亏了13个亿，这就是神经病”。在他看来，将来乐视就是上市公司和汽车两部分，乐...</p>
                </div>
            </article>
            
            <!--Slide-->
            <article class="slide-item">
                <div class="quote"><span class="icon-left"></span></div>
                <div class="author">
                    <h4 class="news2_title">17家上市银行一季报分析：10年来的一次巨变事件</h4>
                </div>
                
                <div class="slide-text">
                    <p id="control-textview" class="news2_des">我关注的17家上市银行2017年一季度本质数据变化分析 写这篇数据分析，一是为了分享，二是提醒大家银行一季度发生了一些10年来的一次巨变事件。 申明：此并不是在推荐那家银行，而是对数据的梳理和分析，具体买卖哪些银行自己定夺。 中国大陆银行受到全球主流投资者唾弃，属于做空对象，就用香-港...</p>
                </div>
            </article>
            
            <!--Slide-->
            <article class="slide-item">
                <div class="quote"><span class="icon-left"></span></div>
                <div class="author">
                    <h4 class="news3_title">谁说微软不行了，它还有爆发的云计算</h4>
                </div>
                
                <div class="slide-text">
                    <p id="control-textview" class="news3_des">编者注：文章作者Sure Dividend，由华盛学院林海编译，主要分析微软近期发布季报及股价相应的变动，并介绍继续持有微软的理由。 科技巨头$微软(MSFT)$在上周四(4月27日)发布了2017财年第三季度财报，财报发布后股价下滑2%，从市场反应看该季度业绩不达投资者的预期。随后，投资者又一次意识到公司...</p>
                </div>
            </article>

            <!--Slide-->
            <article class="slide-item">
                <div class="quote"><span class="icon-left"></span></div>
                <div class="author">
                    <h4 class="news4_title">最近的行情很像2001-2005年的熊市，那时是啥样</h4>
                </div>
                
                <div class="slide-text">
                    <p id="control-textview" class="news4_des">见过一些有经验的老股民说，最近的行情很像2001-2005年的熊市。我一看，还真挺像。于是就上来跟大家分享一下当时的熊市是什么样的。虽然说现在的市场跟当时肯定不可能完全一样，刻舟求剑也要不得。但是至少可以让我们明白一些其中亘古不变的逻辑。 先说说那次熊市是什么样的。对于很老的老股民，2...</p>
                </div>
            </article>

            <!--Slide-->
            <article class="slide-item">
                <div class="quote"><span class="icon-left"></span></div>
                <div class="author">
                    <h4 class="news5_title">成长股陷阱很多，你了解多少？</h4>
                </div>
                
                <div class="slide-text">
                    <p id="control-textview" class="news5_des">研究札记：成长股常见陷阱 不为不可成，不求不可得，不处不可久，不行不可复，无法持久的东西必将终结，价值投资价值和成长不可切割，作为合伙人分享伟大企业的成长。成长的核心是业绩的可持续增长，事实上高估值的成长股陷阱无处不在，真正可保持持续性成长又能确定性预判的品种很少。 估值过高是...</p>
                </div>
            </article>
     
        </div>
        
    </div>    
</section>

<section class="blog-section sec-padd2">
    <div class="container">
        <div class="section-title3 center">
            <h2>为您定制投资组合</h2>
            <p>定位您的投资方向<br>把控风险 合理分配资金 自由选择买卖</p>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="default-blog-news wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                    <div class="lower-content">
												<div id="myStat" data-dimension="250" data-text="18%" data-info="预计年化收益" data-width="30" data-fontsize="38" data-percent="18" data-fgcolor="#48c7ec" data-bgcolor="#eee" class="div-style"></div>
                        <h4><a href="#">稳健计划 I-201701023</a></h4>
                        <div class="post-meta">稳健型  |  182天起投</div>
                        <div class="text">
                            <p>起投金额：10000元<br>剩余可投：2,258,900.00元</p>               
                        </div>
                        <div class="link">
                            <a href="#" class="default_link">立即投资<i class="fa fa-angle-right"></i></a>
                        </div>
                        
                    </div>
                </div>
                
            </div>
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="default-blog-news wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                    <div class="lower-content">
                    		<div id="myStat2" data-dimension="250" data-text="29.8%" data-info="预计年化收益" data-width="30" data-fontsize="38" data-percent="29.8" data-fgcolor="#48c7ec" data-bgcolor="#eee" class="div-style"></div>
                        <h4><a href="#">冒险计划 I-201701063</a></h4>
                        <div class="post-meta">冒险型  |  287天起投</div>
                        <div class="text">
                            <p>起投金额：50000元<br>剩余可投：1,124,800.00元</p>                            
                        </div>
                        <div class="link">
                            <a href="#" class="default_link">立即投资<i class="fa fa-angle-right"></i></a>
                        </div>
                        
                    </div>
                </div>
                
            </div>
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="default-blog-news wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                    <div class="lower-content">
                    		<div id="myStathalf" data-dimension="250" data-text="12.5%" data-info="预计年化收益" data-width="30" data-fontsize="38" data-percent="100" data-fgcolor="#48c7ec" data-bgcolor="#eee" class="div-style"></div>
                        <h4><a href="#">安心计划 I-201701209</a></h4>
                        <div class="post-meta">保守型  |  起投天数：30天</div>
                        <div class="text">
                            <p>起投金额：100元<br>剩余可投：0.00元</p>                            
                        </div>
                        <div class="link">
                            <a href="#" class="default_link" contenteditable="false">已投满</a>
                        </div>
                        
                    </div>
                </div>
                
            </div>
            
        </div>
    </div>
</section>

<section class="consultations sec-padd" style="background-image: url(images/background/5.jpg);">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-6 col-xs-12">   
                <div class="contact-info">
                    <div class="section-title">
                        <h3>联系方式</h3>
                    </div>
                    <div class="text">
                        <p>请选择如下一种联系方式<br>并与我们取得联系！</p>
                    </div>
                    <div class="widget-content">
                        <ul class="list-info">
                            <li><span class="fa fa-phone"></span>电话: 186 8169 3777</li>
                            <li><span class="fa fa-envelope"></span>Email: Maggie_Dida@outlook.com</li>
                            <li><span class="fa fa-clock-o"></span>周一至周五: 9:00am to 16:00pm</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="section-title">
                    <h2>意见反馈</h2>
                </div>
                <div class="default-form-area">
                    <form id="contact_form" name="contact_form" class="default-form" action="inc/sendmail.php" method="post">
                        <div class="row-10 clearfix">
                            <div class="col-md-4 co-sm-6 col-xs-12 column">
                                <div class="form-group">
                                    <input type="text" name="form_name" class="form-control" value="" placeholder="姓名 *" required="">
                                </div>
                                <div class="form-group">
                                    <input type="email" name="form_email" class="form-control required email" value="" placeholder="电子邮箱 *" required="">
                                </div>
                                <div class="form-group">
                                    <div class="select-box">
                                        <select class="text-capitalize selectpicker form-control required" name="form_subject" data-style="g-select" data-width="100%">
                                            <option value="0" selected="">疑难解答</option>
                                            <option value="1">意见反馈</option>
                                            <option value="2">寻求帮助</option>
                                        </select>
                                    </div>
                                        
                                </div>
                            </div>
                            <div class="col-md-8 co-sm-6 col-xs-12 column">
                                <div class="form-group style-2">
                                    <textarea name="form_message" class="form-control textarea required" placeholder="请输入内容..."></textarea>
                                    <input id="form_botcheck" name="form_botcheck" class="form-control" type="hidden" value="">
                                    <button class="thm-btn thm-color" type="submit" data-loading-text="Please wait..."><i class="fa fa-paper-plane"></i></button>
                                </div>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<footer class="main-footer">
     
     <!--Footer Bottom-->
     <section class="footer-bottom">
        <div class="container">
            <div class="pull-left copy-text">
                <p>Copyright &copy; 2017.四川大学 All rights reserved.</p>
                
            </div><!-- /.pull-right -->
            <div class="pull-right get-text">
                <ul class="text-margin-right">
                    <li>软件学院 |  </li>
                    <li>经济学院 |</li>
                    <li> 创新班</li>
                </ul>
            </div><!-- /.pull-left -->
        </div><!-- /.container -->
    </section>
     
</footer>

<!-- Scroll Top Button -->
    <button class="scroll-top tran3s color2_bg">
        <span class="fa fa-angle-up"></span>
    </button>
    <!-- pre loader  -->
    <div class="preloader"></div>


    <!-- jQuery js -->
    <script src="js/jquery.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- jQuery ui js -->
    <script src="js/jquery-ui.js"></script>
    <!-- owl carousel js -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- jQuery validation -->
    <script src="js/jquery.validate.min.js"></script>
    <!-- clamp js-->
    <script src="js/clamp.js"></script>

    <!-- mixit up -->
    <script src="js/wow.js"></script>
    <script src="js/jquery.mixitup.min.js"></script>
    <script src="js/jquery.fitvids.js"></script>
    <script src="js/bootstrap-select.min.js"></script>
    <script src="js/menuzord.js"></script>

    <!-- revolution slider js -->
    <script src="js/jquery.themepunch.tools.min.js"></script>
    <script src="js/jquery.themepunch.revolution.min.js"></script>
    <script src="js/revolution.extension.actions.min.js"></script>
    <script src="js/revolution.extension.carousel.min.js"></script>
    <script src="js/revolution.extension.kenburn.min.js"></script>
    <script src="js/revolution.extension.layeranimation.min.js"></script>
    <script src="js/revolution.extension.migration.min.js"></script>
    <script src="js/revolution.extension.navigation.min.js"></script>
    <script src="js/revolution.extension.parallax.min.js"></script>
    <script src="js/revolution.extension.slideanims.min.js"></script>
    <script src="js/revolution.extension.video.min.js"></script>

    <!-- fancy box -->
    <script src="js/jquery.fancybox.pack.js"></script>
    <script src="js/jquery.polyglot.language.switcher.js"></script>
    <script src="js/nouislider.js"></script>
    <script src="js/jquery.bootstrap-touchspin.js"></script>
    <script src="js/SmoothScroll.js"></script>
    <script src="js/jquery.appear.js"></script>
    <script src="js/jquery.countTo.js"></script>
    <script src="js/jquery.flexslider.js"></script>
    <script src="js/imagezoom.js"></script> 
    <script id="map-script" src="js/default-map.js"></script>
    <script src="js/custom.js"></script>

    <!-- Circliful -->
   <!--  <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script> -->
    <script src="js/jquery.circliful.min.js"></script>

    <script src="myJS/sign.js"></script>
    <script src="myJS/news.js"></script>
    <script>
        $(document).ready(getNews())
    </script>
</div>
    
</body>
</html>
