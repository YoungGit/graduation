<%--
  Created by IntelliJ IDEA.
  User: lizhouyang
  Date: 15/10/19
  Time: 下午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
        <jsp:include page="/WEB-INF/jsp/main_sidebar.jsp"></jsp:include>
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    Page Header
                    <small>Optional description</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                    <li class="active">Here</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">

                <!-- Your Page Content Here -->

            </section><!-- /.content -->
        </div><!-- /.content-wrapper -->
        <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
        <jsp:include page="/WEB-INF/jsp/controll_sidebar.jsp"></jsp:include>
    </div><!-- ./wrapper -->
</body>
</html>
