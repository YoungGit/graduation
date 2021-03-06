<%--
  Created by IntelliJ IDEA.
  User: lizhouyang
  Date: 15/10/19
  Time: 下午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<%=basePath%>resources/adminlte/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>李某某</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i>在线</a>
            </div>
        </div>

        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="搜索...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header">请选择</li>
            <!-- Optionally, you can add icons to the links -->
            <li><a href="#"><i class="fa fa-link"></i> <span>链接</span></a></li>
            <li class="treeview">
                <a href="#"><i class="fa fa-align-center"></i> <span>多层</span> <i
                        class="fa fa-angle-left pull-right"></i></a>
                <ul class="treeview-menu">
                    <li><a href="#">1-1</a></li>
                    <li><a href="#">1-2</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-list"></i> <span>多层2</span> <i
                        class="fa fa-angle-left pull-right"></i></a>
                <ul class="treeview-menu">
                    <li><a href="#">2-1</a></li>
                    <li><a href="#">2-2</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
