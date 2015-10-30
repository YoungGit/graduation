<%--
  Created by IntelliJ IDEA.
  User: lizhouyang
  Date: 15/10/29
  Time: 下午6:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!-- jquery -->
<script src="<%=basePath%>resources/plugins/jQuery/jQuery-2.1.4.min.js"
        type="text/javascript"></script>
<!-- bootstrap js -->
<script src="<%=basePath%>resources/bootstrap/js/bootstrap.min.js"
        type="text/javascript"></script>
<!-- AdminLTE App js -->
<script src="<%=basePath%>resources/adminlte/js/app.min.js"
        type="text/javascript"></script>