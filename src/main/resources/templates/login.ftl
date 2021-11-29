<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>登录</title>

    <link rel="shortcut icon" href="./img/icon/sheep.ico">
    <link rel="stylesheet" href="./css/lql.css">
    <script src="./js/jquery.3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/pageJS/login/1.js"></script>
    <script type="text/javascript" src="./js/pageJS/login/new.js"></script>

    <style>
        .img{background-image: url(./img/bg/Anmi1.jpg)}
        .one,.two{float: left}
    </style>

</head>
<body class="img bg">
    <div class="bg-after"></div>
    <div class="register-out">
        <div class="login">
            <div class="register-title">登录</div>
            <a href="javascript:void(0)" rel="external nofollow" class="back-main"></a>
            <form id="formLogin">
                <div class="input-div">
                    <input type="text" class="input" placeholder="用户名" name="username" id="username">
                </div>
                <div class="error_msg" id="username_msg" style="visibility: hidden">
                    <span>用户名大于等于六位</span>
                </div>
                <div class="input-div">
                    <input type="password" class="input" placeholder="密码" name="password" id="password">
                </div>
                <div class="error_msg" id="password_msg" style="visibility: hidden">
                    <span>密码不能大于等于六位</span>
                </div>
                <div class="input-div">
                    <input type="text" class="v-code-input one" placeholder="验证码" name="vc" id="vc">
                    <img id="imgVerifyCode" src="/verifyCode" class="two v-code-img">
                </div>
                <div class="error_msg" id="code_msg" style="visibility: hidden">
                    <span>验证码输入错误</span>
                </div>
                <div class="check">
                    <label>
                        <input type="checkbox" id="checked" name="checked" value="1">
                        <span class="check-font">保存用户名</span>
                    </label>
                    <span class="check-pwd"><a href="https://www.baidu.com" target="_blank">忘记密码</a></span>
                </div>
                <button class="butt" id="btnSubmit">登录</button>
                <div class="to-register">
                    还没有账号？<a href="register">马上注册</a>
                </div>
            </form>
        </div>
    </div>
</body>
<script type="text/javascript" src="./js/pageJS/login/2.js"></script>
</html>