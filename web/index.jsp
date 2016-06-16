<%--
  Created by IntelliJ IDEA.
  User: imxqd
  Date: 2016/6/14
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <s:iterator value="data">
    <br>
    <s:property />
    <br>
  </s:iterator>
  </body>
</html>
