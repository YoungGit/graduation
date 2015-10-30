<%--
  Created by IntelliJ IDEA.
  User: lizhouyang
  Date: 15/10/19
  Time: 下午9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<meta charset="utf-8">
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<!-- bootstrap css -->
<link rel="stylesheet" type="text/css"
      href="<%=basePath%>resources/bootstrap/css/bootstrap.min.css" />
<!-- Font Awesome -->
<link rel="stylesheet" type="text/css"
      href="<%=basePath%>resources/css/font-awesome.min.css" />
<!-- Ionicons -->
<link rel="stylesheet" type="text/css"
      href="<%=basePath%>resources/css/ionicons.min.css" />
<!-- AdminLET css -->
<link rel="stylesheet" type="text/css"
      href="<%=basePath%>resources/adminlte/css/AdminLTE.min.css">
<!-- AdminLTE Skins -->
<link rel="stylesheet" type="text/css"
      href="<%=basePath%>resources/adminlte/css/skins/skin-green.min.css">
