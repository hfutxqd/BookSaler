<%--
  Created by IntelliJ IDEA.
  User: Henry
  Date: 2016/03/20
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>书店系统登录</title>
  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link href="css/signin.css" rel="stylesheet">
  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script src="js/jquery.min.js"></script>
  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="js/bootstrap.min.js"></script>
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.min.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="container">
  <form class="form-signin" method="post" action="/login">
    <h3 class="form-signin-heading">登陆系统</h3>
    <div class="form-group">
      <label for="inputUsername" class="sr-only">用户名</label>
      <input type="text" id="inputUsername" name="user_name" class="form-control" placeholder="用户名" required autofocus>
    </div>
    <div class="form-group">
      <label for="inputPassword" class="sr-only">密码</label>
      <input type="password" id="inputPassword" name="user_pwd" class="form-control" placeholder="密码" required>
    </div>
    <button class="btn btn-lg btn-primary btn-block">登陆</button>
  </form>
</div>
</body>
</html>
