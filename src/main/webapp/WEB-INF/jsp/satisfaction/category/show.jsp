<%--
  Created by IntelliJ IDEA.
  User: lizhouyang
  Date: 15/10/22
  Time: 上午12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home</title>
    <%@ include file="/WEB-INF/jsp/common_head_css.jsp" %>
</head>
<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">
    <jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/main_sidebar.jsp"></jsp:include>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                商品种类
                <small>已添加种类</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 客户满意度</a></li>
                <li class="active">商品种类</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title" style="text-align: center">${message}</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <div class="form-group">
                                    <label class="col-md-4 control-label" style="text-align: center">id</label>
                                    <div class="col-md-8">
                                        <h4 style="text-align: center">${category.id}</h4>
                                    </div>
                                </div>
                                <label class="col-md-4 control-label" style="text-align: center">种类名称</label>
                                <div class="col-md-8">
                                    <h4 style="text-align: center">${category.name}</h4>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">

                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/controll_sidebar.jsp"></jsp:include>
</div>
<!-- ./wrapper -->
<jsp:include page="/WEB-INF/jsp/common_js.jsp"></jsp:include>
</body>
</html>