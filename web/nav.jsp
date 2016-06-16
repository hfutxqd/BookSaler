<%--
  Created by IntelliJ IDEA.
  User: LCB
  Date: 2016-6-15
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">--%>
<%--<link rel="stylesheet" type="text/css" href="css/animate.css">--%>
<link rel="stylesheet" type="text/css" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="//cdn.bootcss.com/animate.css/3.5.2/animate.css">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="nav-header">
            <a class="navbar-brand" href="#">图书销售系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul id="mynav" class="nav navbar-nav">
                <li>
                    <a href="">进书</a>
                </li>
                <li>
                    <a href="">退书</a>
                </li>
                <li>
                    <a href="">库存信息</a>
                </li>
                <li>
                    <a href="">销售量记录</a>
                </li>
                <li>
                    <a href="">进货记录</a>
                </li>
                <li>
                    <a href="">退货记录</a>
                </li>
                <!--</ul>-->
                </li>
            </ul>

            <ul class="nav navbar-nav pull-right">
                <li class="dropdown">
                    <a href="#" id="infolist" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <img id="avatar" src="img/avatar.png" width="20px" height="20px" title="头像" class="img-circle"> 用户
                    </a>
                    <ul id="avatarlist" class="dropdown-menu animated fadeInRight">
                        <li>
                            <a href="index.php?c=user&a=profile">账户信息</a>
                        </li>
                        <li>
                            <a href="index.php?c=user&a=userlist">用户列表</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a id="logout" href="index.php?c=index&a=login">注销</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%--<script src="js/jquery.min.js"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
<script src="//cdn.bootcss.com/jquery/3.0.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>