<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>注册</title>

    <link rel="stylesheet" href="./css/lql.css">
    <script src="./js/jquery.3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/pageJS/register/1.js"></script>

    <style>
        .img{background-image: url(./img/bg/Anmi2.jpg)}
        .one,.two{float: left}
    </style>

</head>
<body class="img bg">
<div class="bg-after"></div>
<div class="register-out">
    <div class="register">
        <div class="register-title">注册</div>
        <a href="javascript:void(0)" rel="external nofollow" class="back-main" style="top: 475px"></a>
        <form id="formLogin">
            <div class="input-div">
                <#--/[^\w_]/g匹配了所有非0-9,a-z,A-Z字符，并替换为空-->
                <input type="text" class="input" placeholder="用户名" name="username" id="username" onkeyup="this.value=this.value.replace(/[^\w_]/g,'');">
            </div>
            <div class="error_msg" id="username_msg">
                <span></span>
            </div>
            <div class="input-div">
            <input type="password" class="input" placeholder="密码" name="password" id="password">
            </div>
            <div class="error_msg" id="password_msg" style="visibility: hidden">
                <span>密码不能小于六位</span>
            </div>
            <div class="input-div">
                <input type="text" class="input" placeholder="昵称" name="nickname" id="nickname">
            </div>
            <div class="error_msg" id="nickname_msg">
                <span</span>
            </div>
            <div class="input-div">
                <input type="text" class="v-code-input one" placeholder="验证码" name="vc" id="vc" maxlength="4">
                <img id="imgVerifyCode" src="/verifyCode" class="two v-code-img">
            </div>
            <div class="error_msg" id="code_msg" style="visibility: hidden">
                <span>验证码输入错误</span>
            </div>
            <div style="margin-top: 10px;margin-left: 90px">
            <label for="type1"><input type="radio" name="type" value="1" id="type1">我是教师</label>
            <label for="type2"><input type="radio" name="type" value="2" id="type2">我是学生</label>
            </div>
            <button class="butt" id="btnSubmit">注册</button>
        </form>
            <div class="to-register">
                已经有账号了？<a href="login">马上登录</a>
            </div>

    </div>
</div>
</body>
<script type="text/javascript" src="./js/pageJS/register/2.js"></script>
</html>