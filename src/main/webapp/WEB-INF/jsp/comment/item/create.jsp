<%--
  Created by IntelliJ IDEA.
  User: lizhouyang
  Date: 15/10/22
  Time: 下午8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
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
                标题
                <small>可选副标题</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 顶级</a></li>
                <li class="active">当前</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">新建商品</h3>
                        </div>
                        <form:form method="post" commandName="item" cssClass="form-horizontal">
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-md-4 control-label" style="text-align: center">商品种类</label>

                                    <div class="col-md-8">
                                        <form:select path="category.id" cssClass="form-control">
                                            <form:options items="${categoryList}" itemValue="id" itemLabel="name" />
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" style="text-align: center">商品名称</label>

                                    <div class="col-md-8">
                                        <form:input path="name" cssClass="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" style="text-align: center">特征数量</label>

                                    <div class="col-md-8">
                                        <form:input path="aspectNum" cssClass="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" style="text-align: center">特征种子词</label>

                                    <div class="col-md-8">
                                        <form:input path="aspectSeed" cssClass="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label" style="text-align: center">特征词</label>

                                    <div class="col-md-8">
                                        <form:input path="aspectWords" cssClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary"
                                             style="text-align: center">提交</button>
                            </div>
                        </form:form>
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
</body>
</html>
