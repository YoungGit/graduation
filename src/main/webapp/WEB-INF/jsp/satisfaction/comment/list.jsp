<%--
  Created by IntelliJ IDEA.
  User: lizhouyang
  Date: 15/10/29
  Time: 下午2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <%@ include file="/WEB-INF/jsp/common_head_css.jsp" %>
    <style type="text/css">
        .td-content {
            width: 70%;
        }
        .td-center {
            text-align: center;
        }
    </style>
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
                ${item.name}
                <small>评论合集</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 顶级</a></li>
                <li class="active">当前</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <%--<div class="box-header">--%>
                            <%--<h3 class="box-title">标题</h3>--%>
                        <%--</div>--%>
                        <div class="box-body">
                            <table id="comment_table" class="table table-bordered table-hover table-striped">
                                <thead>
                                <tr>
                                    <th class="td-center">所属商品</th>
                                    <th class="td-center">内容</th>
                                    <th class="td-center">分析展示</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageEntity.content}" var="comment">
                                    <tr>
                                        <td class="td-center">${item.name}</td>
                                        <td class="td-content">${comment.raw}</td>
                                        <td class="td-center"><a href="<%=basePath%>satisfaction/comment/analysis/${comment.id}"
                                               class="btn btn-lg btn-info">分析</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <ul class="pagination pull-right">
                                <c:choose>
                                    <c:when test="${curIndex == 1}">
                                        <li class="disabled"><a href="#">上一页</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li>
                                            <a href="<%=basePath%>satisfaction/comment/list/${item.id}?page=${curIndex-1}">
                                                上一页
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                                <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                                    <c:url var="pageUrl" value="${item.id}?page=${i}"/>
                                    <c:choose>
                                        <c:when test="${i == curIndex}">
                                            <li class="active"><a href="${pageUrl}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="${pageUrl}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <c:choose>
                                    <c:when test="${curIndex == pageEntity.totalPages}">
                                        <li class="disabled"><a href="#">下一页</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li>
                                            <a href="<%=basePath%>satisfaction/comment/list/${item.id}?page=${curIndex+1}">
                                                下一页
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </ul>
                        </div>
                        <!-- /.box-footer -->
                    </div>
                    <!-- /.box -->
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
