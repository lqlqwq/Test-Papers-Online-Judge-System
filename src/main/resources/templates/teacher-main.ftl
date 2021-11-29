<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>教师主界面</title>

    <link rel="shortcut icon" href="./img/icon/sheep.ico">
    <link rel="stylesheet" href="./css/main.css">
    <script src="./js/jquery.3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/art-template.js"></script>
    <script type="text/javascript" src="./js/pageJS/teacher-main/1.js"></script>

    <style>
        .img{background-image: url(./img/bg/Hiten7.png)}
        .status{font-size: 20px;font-weight: 600}
    </style>

    <script type="text/html" id="testTemplate">
        <tr>
            <td>{{test_id}}</td>
            <td>{{test_name}}</td>
            <td>{{ans_num}}</td>
            <td>{{finishNum}}</td>
            <td>{{createtime}}</td>
            <td>{{endtime}}</td>
            <td class="status" name="status" id="{{test_id}}status" style="color:{{color}};">{{status}}</td>
            <td>{{avgscore}}</td>
            <td><a href="javascript:void(0)" rel="external nofollow" id="{{test_id}}score" name="scorea"">详细状况</a></td>
        </tr>
    </script>
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
        <li><a href="javascript:void(0)" rel="external nofollow" style="color: #9bff08">考试状况查询</a></li>
        <li><a href="javascript:void(0)" rel="external nofollow" id="gotest">发布考试</a></li>
        <span><a href="javascript:void(0)" rel="external nofollow" class="user" id="user-main">用户中心</a></span>
        <span class="user" style="color: #09ffb9">欢迎，${loginUser.user_nickname}</span>
    </ul>
</div>
<div class="table-box mid">
    <div><a href="#logo" class="go-top"></a></div>          <#--回顶部-->
    <table style="margin: 0 auto" id="test-table">
        <tr class="table-title">
            <td>考试ID</td>
            <td style="width: 250px">考试名称</td>
            <td>考试题数</td>
            <td>完成人数</td>
            <td style="width: 150px">创建时间</td>
            <td style="width: 150px">截止时间</td>
            <td>当前状态</td>
            <td>平均分</td>
            <td>详细状况</td>
        </tr>
    </table>
    <div><input type="hidden" value="1" id="page"><a href="javascript:void(0)" rel="external nofollow" id="nextPage" class="nextPage">下一页</a></div>
</div>
</body>
</html>