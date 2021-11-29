<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>具体完成情况</title>

    <link rel="shortcut icon" href="./img/icon/sheep.ico">
    <link rel="stylesheet" href="./css/status.css">
    <script src="./js/jquery.3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/echarts.js"></script>
    <script src="./js/art-template.js"></script>

    <style>
        .img{background-image: url(./img/bg/Hiten6.png)}
    </style>
    <script type="text/html" id="mesTemplate">
        <div class="discuss-box" style="position: relative">
            <div>{{mes}}</div>
            <div style="position: absolute;top: 0px;right: -100px;font-size: 12px;color: #034fb4;font-weight: bold">{{user_nickname}}&nbsp;{{mes_time}}</div>
        </div>
    </script>
    <script type="text/html" id="testTemplate">
        <table class="mar-left">
            <tr class="score-main">
                <td>{{order}}</td>
                <td>{{status}}</td>
                <td style="width: 130px">{{youAns}}</td>
                <td style="width: 130px">{{teacherAns}}</td>
                <td style="width: 150px"><a href="javascript:void(0)" rel="external nofollow" class="chart" id="{{order}}chart" name="photo">班级数据</a></td>
                <td style="width: 150px"><a href="javascript:void(0)" rel="external nofollow" class="chart" id="{{order}}discuss" name="dis">查看评论</a></td>
            </tr>
        </table>
        <div>
            <div class="charts-out-box">
                <div class="test" id="{{order}}chart1" style="display: none"></div>
                <div class="test" id="{{order}}chart2" style="display: none"></div>
            </div>
            <div class="discuss-out-box" id="{{order}}discuss1" style="display: none">
                <div class="discuss-title">教师评论:</div>
                <div class="discuss-box" id="{{order}}discuss1null">抱歉，暂无教师评论!</div>
            </div>
            <div class="discuss-out-box" id="{{order}}discuss2" style="display: none">
                <div class="discuss-title">学生评论:</div>
                <div class="discuss-box" id="{{order}}discuss2null">抱歉，暂无学生评论!</div>
            </div>
        </div>
    </script>
    <script type="text/javascript" src="./js/pageJS/teacher-stu/1.js"></script>
    <script type="text/javascript">
        $(function () {
          <#if !loginUser ??>
            $('#user-main').click(function () {
                alert('不登录你操作锤子呢，给我爪巴');
                location.href="login";
            })
          </#if>
          <#if loginUser ??>
             $('#user-main').click(function () {
                 location.href="teacher-info";
             })
          </#if>
        })
    </script>
</head>
<body class="img bg bg-limit">
<div class="bg-after-index"></div>
<div class="title">
    <ul>
        <li><a href="javascript:void(0)" rel="external nofollow" class="logo" id="logo">大肥羊智能评卷系统</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow" id="backmain">考试状况查询</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow" id="gotest">发布考试</a></li>
        <span><a href="javascript:void(0)" rel="external nofollow" class="user" id="user-main">用户中心</a></span>
        <span class="user" style="color: #09ffb9">欢迎，${loginUser.user_nickname}</span>
    </ul>
</div>
<div><a href="#logo" class="go-top"></a></div>          <#--回顶部-->
<div><a href="javascript:void(0)" rel="external nofollow" class="go-back" id="back"></a></div>
<div class="table-box mid" id="tablebox">
    <div class="left-box" id="leftbox">
        <h4 style="margin-top: 50px;font-size: 18px;font-family: '微软雅黑 Light';text-align: center">考试结果</h4>
        <h1 style="color: red;text-align: center" id="yournum">${stuTest.score}</h1>
        <h4 style="margin-top: 40px;font-size: 18px;font-family: '微软雅黑 Light';text-align: center">班级平均分</h4>
        <h1 style="color: red;text-align: center" id="avgScore">66</h1>
        <h4 style="margin-top: 40px;font-size: 18px;font-family: '微软雅黑 Light';text-align: center">已完成人数</h4>
        <h1 style="text-align: center" id="finishNum">66</h1>
        <input type="hidden" id="testid">
    </div>
    <div class="scorebox clearfix" id="score">
        <table class="mar-left">
            <tr class="score-title">
                <td>题号</td>
                <td>状态</td>
                <td style="width: 130px">你的答案</td>
                <td style="width: 130px">正确答案</td>
                <td style="width: 150px">班级情况</td>
                <td style="width: 150px">评论查看</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>