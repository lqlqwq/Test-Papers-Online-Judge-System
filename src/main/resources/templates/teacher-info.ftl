<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>教师中心</title>

    <link rel="shortcut icon" href="./img/icon/sheep.ico">
    <link rel="stylesheet" href="./css/info.css">
    <script src="./js/jquery.3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/pageJS/teacher-info/1.js"></script>
    
    <script type="text/javascript">
        $(function () {
          <#if !loginUser ??>
            $('#user-main,#nickname-button,#logout').click(function () {
                alert('不登录你操作锤子呢，给我爪巴');
                location.href="login"
            })
          </#if>
        })
    </script>

    <style>
        .img{background-image: url(./img/bg/Hiten4.png)}
    </style>
</head>
<body class="img bg">
<div class="bg-after-index"></div>
<div class="title">
    <ul>
        <li><a href="javascript:void(0)" rel="external nofollow" class="logo" id="logo">大肥羊智能评卷系统</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow" id="backmain">考试状况查询</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow" id="gotest">发布考试</a></li>
        <span><a href="javascript:void(0)" rel="external nofollow" class="user">用户中心</a></span>
        <span class="user" style="color: #09ffb9">欢迎，${loginUser.user_nickname}</span>
    </ul>
</div>
<div class="table-box mid">
    <div class="left-box">
        <h4 class="function" style="margin-top: 50px"><a href="javascript:void(0)" rel="external nofollow" id="re-password" style="color: #9bff08">密码修改</a></h4>
        <h4 class="function"><a href="javascript:void(0)" rel="external nofollow" id="re-nickname">昵称修改</a></h4>
        <h4 class="function"><a href="javascript:void(0)" rel="external nofollow" id="logout">退出登录</a></h4>
    </div>
    <div class="nickname">
        <div id="re-password-div">
            <form id="pw-form">
                <div class="oldpass-title">修改密码</div>
                <div class="inputtext" style="margin-left: 300px"><span>请输入现在的密码：</span><input class="inputbox" type="password" id="oldpw" name="oldpw"></div>
                <div class="inputtext" style="margin-left: 300px"><span>请输入新的密码：</span><input class="inputbox" type="password" id="newpw" name="newpw" style="margin-left: 17px"></div>
                <button class="button" id="pw-button">确认修改</button>
            </form>
        </div>
        <div id="re-nickname-div" style="display: none">
            <form id="nickname-form">
                <div class="oldpass-title">修改昵称</div>
                <div class="inputtext" style="margin-left: 300px"><span>请输入新的昵称：</span><input class="textbox" type="text" style="margin-left: 17px" id="nickname" name="nickname"></div>
                <button class="button" id="nickname-button">确认修改</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>