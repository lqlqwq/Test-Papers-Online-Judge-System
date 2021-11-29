<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta name="description" content="大肥羊智能答题卡批阅网站，一款智能的评卷系统，让教师更省心，让家长更放心，让学生更上心，致力于打造更好的师生互动评卷系统，让教师在寒暑假不再操心">
    <meta name="Keywords" content="大肥羊,答题卡,智能批阅,师生互动,在线系统,作业提交">
    <#--让他用edge(最高)方式渲染  针对于IE8-->
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>大肥羊评卷系统</title>

    <link rel="shortcut icon" href="./img/icon/sheep.ico">
    <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="./css/lql.css">
    <script src="./js/jquery.3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/unslider.min.js"></script>
    <script type="text/javascript" src="./js/pageJS/index/1.js"></script>
    <script type="text/javascript" src="./js/pageJS/index/new.js"></script>
    <script type="text/javascript" src="./js/pageJS/index/spark.js"></script>
    <script type="text/javascript" src="./js/pageJS/index/snow.js"></script>
    <script type="text/javascript" src="./js/pageJS/index/clipboard.js"></script>


    <style>
        .img{background-image: url(./img/bg/Hiten1.png)}
        @font-face {
            font-family: 'iconfont';
            src:
                    url(./img/icon/iconfont.woff2?t=1635772019354) format('woff2'),
                    url(./img/icon/iconfont.woff?t=1635772019354) format('woff'),
                    url(./img/icon/iconfont.ttf?t=1635772019354) format('truetype');
        }
        .iconfont {
            font-family: "iconfont" !important;
            font-size: 16px;
            font-style: normal;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }
    </style>
    <script type="text/javascript">
        $(function () {
<#if !loginUser ??>
    $('#user-main').click(function () {
        alert('不登录你操作锤子呢，给我爪巴');
        location.href="login"
    })
</#if>
    <#if loginUser ??>
    var welcome = document.getElementById("welcome");
    welcome.innerHTML = "欢迎，${loginUser.user_nickname}";
    $('#user-main').click(function () {
        if (${loginUser.user_type}==1)
        {
            location.href = "teacher-info"
        }
    else
        {
            location.href = "stu-info"
        }
    })
    </#if>
        })
    </script>
</head>
<body class="img bg">
<img src="./img/bg/Hiten1.png" alt="" style="display: none">
<div class="bg-after-index"></div>
<div id="snow"></div>
<div style="display: none" id="top"><a href="#logo" class="go-top"></a></div>          <#--回顶部-->
<div id="effects" class="effects"><a href="javascript:void(0)" class="effects-img" title="关闭特效"></a></div>          <#--关闭特效-->
<div class="title" style="position: relative">
    <ul>
        <li><a href="javascript:void(0)" class="logo">大肥羊智能评卷系统</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow">产品简介</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow">支持</a></li>
        <span><a href="javascript:void(0)" rel="external nofollow" class="user" id="user-main">用户中心</a></span>
        <span class="user" style="color: #97ff95" id="welcome">欢迎</span>
    </ul>
</div>
<div class="mainbox mid">
    <h3>大肥羊智能评卷系统</h3>
    <h1 style="margin-top: 40px">一款智能的评卷系统</h1>
    <h2 style="margin-top: 40px">让教师更省心</h2>
    <h2 style="margin-top: 10px">让家长更放心</h2>
    <h2 style="margin-top: 10px">让学生更上心</h2>
    <h4 style="margin-top: 30px">大肥羊评卷系统，致力于打造更好的师生互动评卷系统，让教师在寒暑假不再操心</h4>
    <a href="register" class="button">马上注册</a><a href="login" class="button" style="margin-left: 40px">立刻登录</a><a href="javascript:void(0)" class="button" style="margin-left: 40px" id="express">进行体验</a>
</div>
<div class="reason mid" id="aaa">
    <div class="reason-left">
        <h7 style="margin-top: 35px" class="bigfatsheep">为什么选择&nbsp&nbsp大肥羊</h7>
        <span class="shape"></span><span class="now">迄今为止</span>
    </div>
    <div class="reason-right">
        <ul class="num">
            <li>10+</li>
            <li>500+</li>
            <li>24000+</li>
        </ul>
        <ul class="num-exp">
            <li style="margin-left: 73px">合作学校</li>
            <li style="margin-left: 75px">教师使用</li>
            <li style="margin-left: 100px">学生使用</li>
        </ul>
    </div>
</div>
<div class="exp mid" name="aaa">
    <span style="margin-left: 430px"><h2>为教师和学生</h2></span><span style="color: #1f3eff"><h2>&nbsp&nbsp&nbsp量身定制的服务</h2></span>
    <h5 class="exp-bot">可靠的答题卡批阅服务，并能提供您喜爱的诸多功能</h5>
</div>
<div class="details mid">
    <ul>
        <li class="sparkley"><h2>准确识别</h2><h4 style="display: inline-block">答题卡识别准确率高达99.9999999999999%</h4><span class="iconfont" style="font-size: 24px">&#xe600;</span></li>
        <li class="sparkley"><h2>快速开始</h2><h4>注册即可开始使用</h4></li>
        <li class="sparkley"><h2>简单使用</h2><h4>一键生成答题卡模板</h4></li>
        <li class="sparkley"><h2>数据分析</h2><h4>轻松分析学生数据信息</h4></li>
        <li class="sparkley"><h2>可视化图表</h2><h4>让掌握学生学习情况变得更加简单</h4></li>
        <li class="sparkley"><h2>互动留言</h2><h4>远距离也能轻松指导学生学习</h4></li>
    </ul>
</div>
<div class="evaluation mid" id="evaluation">
    <div id="left-icon-box" style="display: none"><a href="javascript:void(0)" rel="external nofollow" class="next-icon" name="xxx"></a></div>
    <div id="right-icon-box" style="display: none"><a href="javascript:void(0)" rel="external nofollow" class="prev-icon" name="xxx"></a></div>
    <div class="banner" id="b04">
        <ul>
            <li><text class="iconfont">教师可以登录用户名lqlqwq密码159753进行体验&#xe601;&#xe601;</text></li>
            <li><text class="iconfont">学生可以登录用户名shagou密码123321进行体验&#xe600;&#xe600;&#xe600;</text></li>
            <li><text class="iconfont">点击下载学生用交卷答题卡&#xe618;&#xe618;&#xe618;</text></li>
            <li><text class="iconfont">要是让客户看见我们的评论都是编的就完蛋了&#xe68c;&#xe846;&#xe613;</text></li>
        </ul>
    </div>
</div>
<div class="copyok">复制成功！(=・ω・=)</div>
<div class="support mid">
    <div class="bottom-left">
        <h2 style="margin-top: 85px" id="sup">大肥羊</h2>
        <h5 style="margin-top: 20px">致力于打造更好的师生互动评卷系统</h5>
        <h5 style="margin-top: 35px">© 大肥羊 • All Rights Reserved.</h5>
        <div class="icon1"></div><div class="icon2"></div><button class="icon3 btn" title="点击复制联系邮箱" data-clipboard-text="lqlqwq1@gmail.com"></button>
    </div>
    <div class="bottom-mid">
        <h4 style="margin-top: 88px">首页</h4>
        <ul>
            <li><a href="">注册</a></li>
            <li><a href="">登录</a></li>
            <li><a href="">用户中心</a></li>
            <li><a href="">编不出来了</a></li>
        </ul>
    </div>
    <div class="bottom-mid">
        <h4 style="margin-top: 88px">支持</h4>
        <ul>
            <li><a href="">服务条款</a></li>
            <li><a href="">常见问题</a></li>
            <li><a href="">联系方式</a></li>
            <li><a href="">编不出来了</a></li>
        </ul>
    </div>
</div>
<div class="gov"><a href="http://beian.miit.gov.cn/">浙ICP备2021034010号-1</a><span></span><a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010202001997">浙公网安备 33010202001997号</a></div>
</body>
</html>