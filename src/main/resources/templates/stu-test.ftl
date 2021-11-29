<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>试卷提交</title>

    <link rel="shortcut icon" href="./img/icon/sheep.ico">
    <link rel="stylesheet" href="./css/info.css">
    <script src="./js/jquery.3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/pageJS/stu-test/1.js"></script>

    <style>
        .img{background-image: url(./img/bg/纯白可怜2.png)}
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
             $('#user-main').click(function () {
                 location.href="stu-info";
             })
          </#if>
            $('#backmain').click(function () {
                location.href="stu-main";
            })
            $('#logo').click(function () {
                location.href='index';
            })
        })
    </script>
</head>
<body class="img bg">
<div class="bg-after-index"></div>
<div class="title">
    <ul>
        <li><a href="javascript:void(0)" rel="external nofollow" class="logo" id="logo">大肥羊智能评卷系统</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow" id="backmain">已完成试卷一览</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow" style="color: #9bff08">前往交卷</a></li>
        <span><a href="javascript:void(0)" rel="external nofollow" class="user" id="user-main">用户中心</a></span>
        <span class="user" style="color: #09ffb9">欢迎，${loginUser.user_nickname}</span>
    </ul>
</div>
<div class="table-box mid">
    <div class="left-box">
        <h4 class="function" style="margin-top: 50px"><a href="" >试卷提交</a></h4>
    </div>
    <div class="nickname" style="position: relative">
        <div class="oldpass">
            <form>
                <div class="oldpass-title">试卷提交</div>
                <div class="inputtext" style="margin-left: 300px"><span>请输入考试ID：</span><input class="inputbox" type="number" style="margin-left: 2px"name="testid" id="testid"></div>
                <div class="inputtext" style="margin-left: 300px"><span>请上传答题卡：</span><input class="filebox" type="file" name="testphoto" id="testphoto" accept="image/*"></div>
            </form>
            <button class="button" id="upload">确认提交</button>
        </div>
        <div class="bar-outbox">
            <div class="bar" id="bar"></div>
            <div class="bar-num">0%</div>
        </div>
    </div>
</div>
</body>
</html>