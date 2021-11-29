<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>发布考试</title>

    <link rel="shortcut icon" href="./img/icon/sheep.ico">
    <link rel="stylesheet" href="./css/info.css">
    <script src="./js/jquery.3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./js/pageJS/teacher-create/1.js"></script>

    <style>
        .img{background-image: url(./img/bg/纯白可怜1.jpg)}
    </style>

    <script type="text/javascript">
        $(function () {
          <#if !loginUser ??>
            $('#user-main').click(function () {
                alert('不登录你操作锤子呢，给我爪巴');
                location.href = "login";
            })
          </#if>
          <#if loginUser ??>
             $('#user-main').click(function () {
                 location.href = "teacher-info";
             })
          </#if>
        })
    </script>
</head>
<body class="img bg">
<div class="bg-after-index"></div>
<div class="title">
    <ul>
        <li><a href="javascript:void(0)" rel="external nofollow" class="logo" id="logo">大肥羊智能评卷系统</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow" id="backmain">考试状况查询</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow" style="color: #9bff08">发布考试</a></li>
        <span><a href="javascript:void(0)" rel="external nofollow" class="user" id="user-main">用户中心</a></span>
        <span class="user" style="color: #09ffb9">欢迎，${loginUser.user_nickname}</span>
    </ul>
</div>
<div class="table-box mid">
    <div class="left-box">
        <h4 class="function" style="margin-top: 50px"><a href="javascript:void(0)" rel="external nofollow" id="create-test-butt">发布考试</a></h4>
        <h4 class="function" style="margin-top: 50px"><a href="javascript:void(0)" rel="external nofollow" id="re-ans">修改答案</a></h4>
    </div>
    <div class="nickname">
        <div id="test-out-box">
            <form id="create">
                <div id="test-box">
                    <div class="oldpass-title">发布考试</div>
                    <div class="inputtext" style="margin-left: 300px"><span>请输入考试名称：</span><input class="textbox" id="name" name="name" type="text" style="margin-left: 17px"></div>
                    <div class="inputtext" style="margin-left: 300px"><span>请输入考试题数：</span><input class="textbox" id="num" name="num" type="number" style="margin-left: 17px"></div>
                    <div class="inputtext" style="margin-left: 300px"><span>请输入截止日期：</span><input class="textbox" id="date" name="date" type="date" style="margin-left: 17px" autocomplete="now"></div>
                    <div class="inputtext" style="margin-left: 300px"><span>请输入截止时间：</span><input class="textbox" id="time" name="time" type="time" style="margin-left: 17px"></div>
                    <button class="button" id="set-ans" type="button">设置答案</button>
                </div>
                <div class="setans" id="ans-box" style="display: none">
                    <div class="inputtext" style="margin-left: 350px" id="ansbox1"><span>1-5题</span><input class="textbox" type="text" id="ansvalue1" name="ansvalue1" onkeyup="value=value.replace(/[^A-D]/g,'')" maxlength="5"><span style="margin-left: 5px">输入样例:</span><span class="sample">ABCDA</span><span style="margin-left: 5px"><a href="./img/other/origin.png" download="origin" class="origin">下载答题卡模板</a></span></div>
                    <div class="inputtext" style="margin-left: 340px" id="ansbox2"><span>6-10题</span><input class="textbox" type="text" id="ansvalue2" name="ansvalue2" onkeyup="value=value.replace(/[^A-D]/g,'')" maxlength="5"></div>
                    <div class="inputtext" style="margin-left: 336px" id="ansbox3"><span>11-15题</span><input class="textbox" type="text" id="ansvalue3" name="ansvalue3" onkeyup="value=value.replace(/[^A-D]/g,'')" maxlength="5"></div>
                    <div class="inputtext" style="margin-left: 330px" id="ansbox4"><span>16-20题</span><input class="textbox" type="text" id="ansvalue4" name="ansvalue4" onkeyup="value=value.replace(/[^A-D]/g,'')" maxlength="5"></div>
                    <div class="inputtext" style="margin-left: 330px" id="ansbox5"><span>21-25题</span><input class="textbox" type="text" id="ansvalue5" name="ansvalue5" onkeyup="value=value.replace(/[^A-D]/g,'')" maxlength="5"></div>
                    <div class="inputtext" style="margin-left: 327px" id="ansbox6"><span>26-30题</span><input class="textbox" type="text" id="ansvalue6" name="ansvalue6" onkeyup="value=value.replace(/[^A-D]/g,'')" maxlength="5"></div>
                    <div class="inputtext" style="margin-left: 330px" id="ansbox7"><span>31-35题</span><input class="textbox" type="text" id="ansvalue7" name="ansvalue7" onkeyup="value=value.replace(/[^A-D]/g,'')" maxlength="5"></div>
                    <div class="inputtext" style="margin-left: 327px" id="ansbox8"><span>36-40题</span><input class="textbox" type="text" id="ansvalue8" name="ansvalue8" onkeyup="value=value.replace(/[^A-D]/g,'')" maxlength="5"></div>
                    <button class="button" id="gogogo">提交</button>
                </div>
            </form>
        </div>
        <div id="re-test-out-box" style="display: none">
            <div id="re-test-search-box">
                <form id="testid-search">
                    <div class="oldpass-title">修改答案</div>
                    <div class="inputtext" style="margin-left: 300px"><span>请输入考试ID：</span><input class="textbox" id="testid" name="testid" type="number" style="margin-left: 17px"></div>
                    <button class="button" id="search">查询答案</button>
                </form>
            </div>
            <div id="re-test-revise-box" style="display: none">
                <form id="revise">
                    <div class="inputtext" style="display: none;margin-left: 350px" id="revisebox1"><span>1-5题</span>  <input class="textbox" type="text" id="revisevalue1" name="revisevalue1"><span style="margin-left: 5px">输入样例:</span><span class="sample">ABCDA</span></div>
                    <div class="inputtext" style="display: none;margin-left: 340px" id="revisebox2"><span>6-10题</span> <input class="textbox" type="text" id="revisevalue2" name="revisevalue2"></div>
                    <div class="inputtext" style="display: none;margin-left: 336px" id="revisebox3"><span>11-15题</span><input class="textbox" type="text" id="revisevalue3" name="revisevalue3"></div>
                    <div class="inputtext" style="display: none;margin-left: 330px" id="revisebox4"><span>16-20题</span><input class="textbox" type="text" id="revisevalue4" name="revisevalue4"></div>
                    <div class="inputtext" style="display: none;margin-left: 330px" id="revisebox5"><span>21-25题</span><input class="textbox" type="text" id="revisevalue5" name="revisevalue5"></div>
                    <div class="inputtext" style="display: none;margin-left: 327px" id="revisebox6"><span>26-30题</span><input class="textbox" type="text" id="revisevalue6" name="revisevalue6"></div>
                    <div class="inputtext" style="display: none;margin-left: 330px" id="revisebox7"><span>31-35题</span><input class="textbox" type="text" id="revisevalue7" name="revisevalue7"></div>
                    <div class="inputtext" style="display: none;margin-left: 327px" id="revisebox8"><span>36-40题</span><input class="textbox" type="text" id="revisevalue8" name="revisevalue8"></div>
                    <input type="hidden" id="hideid" name="hideid">
                    <button class="button" id="confirm-revise">确认修改</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>