<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>教师查询-试卷结果</title>

    <link rel="shortcut icon" href="./img/icon/sheep.ico">
    <link rel="stylesheet" href="./css/status.css">
    <script src="./js/jquery.3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/echarts.js"></script>
    <script src="./js/art-template.js"></script>


    <style>
        .img{background-image: url(./img/bg/Hiten4.png)}
    </style>

    <script type="text/html" id="testTemplate">
        <table class="mar-left">
            <tr class="score-main">
                <td>{{order}}</td>
                <td style="width: 130px">{{teacherAns}}</td>
                <td>{{truePercent}}</td>
                <td style="width: 130px">{{wrongNum}}</td>
                <td style="width: 150px"><a href="javascript:void(0)" rel="external nofollow" class="chart" id="{{order}}chart" name="photo">班级数据</a></td>
                <td style="width: 150px"><a href="javascript:void(0)" rel="external nofollow" class="chart" id="{{order}}discuss" name="dis">查看评论</a></td>
            </tr>
        </table>
        <div>
            <div class="charts-out-box">
                <input type="hidden" id="{{order}}ansA" value="{{ansA}}">
                <input type="hidden" id="{{order}}ansB" value="{{ansB}}">
                <input type="hidden" id="{{order}}ansC" value="{{ansC}}">
                <input type="hidden" id="{{order}}ansD" value="{{ansD}}">
                <input type="hidden" id="{{order}}ansNull" value="{{ansNull}}">
                <input type="hidden" id="{{order}}ansRight" value="{{ansRight}}">
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
            <div class="discuss-out-box" id="{{order}}discuss3" style="display: none">
                <div class="discuss-title">发表评论:</div>
                <div class="discuss-box-text"><textarea class="dis-input" placeholder="请输入评论" style="resize: none" id="{{order}}textarea"></textarea>
                    <a href="javascript:void(0)" rel="external nofollow" class="dis-button" id="{{order}}text" name="textbutton">提交</a>
                </div>
            </div>
        </div>
    </script>
    <script type="text/html" id="stuTemplate">
        <tr>
            <td>{{num}}</td>
            <td style="width: 250px">{{test_name}}</td>
            <td>{{nickname}}</td>
            <td style="width: 150px">{{createtime}}</td>
            <td>{{score}}</td>
            <td><a href="javascript:void(0)" rel="external nofollow" id="{{user_id}}detail" name="detail">详细状况</a></td>
        </tr>
    </script>
    <script type="text/html" id="mesTemplate">
        <div class="discuss-box" style="position: relative">
            <div>{{mes}}</div>
            <div style="position: absolute;top: 0px;right: -100px;font-size: 12px;color: #034fb4;font-weight: bold">{{user_nickname}}&nbsp;{{mes_time}}</div>
        </div>
    </script>
    <script type="text/javascript" src="./js/pageJS/teacher-status/1.js"></script>
    <script>
        $(function () {
          <#if !loginUser ??>
            $('#user-main').click(function () {
                alert('不登录你操作锤子呢，给我爪巴');
                location.href="login"
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
<div class="table-box mid" id="tablebox">
    <div class="left-box" id="leftbox">
        <input type="hidden" id="testid">
        <h4 class="function" style="margin-top: 50px"><a href="javascript:void(0)" rel="external nofollow" style="color:#0064ff" id="testRepor">考试结果</a></h4>
        <h4 class="function" style="margin-top: 30px"><a href="javascript:void(0)" rel="external nofollow" id="stuRepor">上交情况</a></h4>
        <h4 style="margin-top: 50px;font-size: 18px;font-family: '微软雅黑 Light';text-align: center">已完成人数</h4>
        <h1 style="text-align: center" id="finishNum">66</h1>
        <h4 style="margin-top: 40px;font-size: 18px;font-family: '微软雅黑 Light';text-align: center">平均分</h4>
        <h1 style="color: red;text-align: center" id="avgScore">66</h1>
        <h4 style="margin-top: 40px;font-size: 18px;font-family: '微软雅黑 Light';text-align: center">最高分</h4>
        <h1 style="color: red;text-align: center" id="maxScore">66</h1>
        <h4 style="margin-top: 40px;font-size: 18px;font-family: '微软雅黑 Light';text-align: center">最低分</h4>
        <h1 style="color: red;text-align: center" id="minScore">66</h1>
    </div>
    <div class="scorebox" id="score">
        <table class="mar-left">
            <tr class="score-title">
                <td>题号</td>
                <td style="width: 130px">正确答案</td>
                <td>正确率</td>
                <td style="width: 130px">错选人数</td>
                <td style="width: 150px">班级情况</td>
                <td style="width: 150px">评论查看</td>
            </tr>
        </table>
    </div>
    <div class="repor-box" id="repor-box"  style="display: none">
        <table style="margin: 0 auto" id="repor-table">
            <tr class="repor-title">
                <td>交卷次序</td>
                <td style="width: 250px">考试名称</td>
                <td>姓名</td>
                <td style="width: 150px">完成时间</td>
                <td>成绩</td>
                <td>详细状况</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>