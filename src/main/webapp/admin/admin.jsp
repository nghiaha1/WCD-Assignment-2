<%@ page import="com.ass.wcdassignment2.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ass.wcdassignment2.entity.Category" %>
<%@ page import="com.ass.wcdassignment2.entity.Product" %>
<%@ page import="com.ass.wcdassignment2.entity.Chef" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Category cObj = (Category) request.getAttribute("cObj");
    if (cObj == null) {
        cObj = new Category();
    }
    Product pObj = (Product) request.getAttribute("pObj");
    if (pObj == null) {
        pObj = new Product();
    }
    Chef chObj = (Chef) request.getAttribute("chObj");
    if (chObj == null) {
        chObj = new Chef();
    }
    List<Category> cList = (List<Category>) request.getAttribute("cList");
    if(cList == null){
        cList = new ArrayList<>();
    }
    List<Product> pList = (List<Product>) request.getAttribute("pList");
    if(pList == null){
        pList = new ArrayList<>();
    }
    List<Chef> chList = (List<Chef>) request.getAttribute("chList");
    if(chList == null){
        chList = new ArrayList<>();
    }
%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="/admin/includes/navbar.jsp"></jsp:include>

    <!-- Main Sidebar Container -->
    <jsp:include page="/admin/includes/sidebar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>DataTables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">DataTables</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">Category List</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Created At</th>
                                        <th>Updated At</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Category obj : cList) { %>
                                    <tr>
                                        <td><%= obj.getId() %></td>
                                        <td><%= obj.getName() %></td>
                                        <td><%= obj.getCreatedAt() %></td>
                                        <td><%= obj.getUpdatedAt() %></td>
                                        <td>
                                            <a href="/admin/categories/detail?id=<%= obj.getId() %>">Detail</a>&nbsp;&nbsp;
                                            <a href="/admin/categories/edit?id=<%= obj.getId() %>">Edit</a>&nbsp;&nbsp;
                                            <a href="/admin/categories/delete?id=<%= obj.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
                                        </td>
                                    </tr>
                                    <% } %>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Created At</th>
                                        <th>Updated At</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>

                            <div class="card-header">
                                <h3 class="card-title">Product List</h3>
                            </div>
                            <div class="card-body">
                                <table  class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Category</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Detail</th>
                                        <th>Thumbnail</th>
                                        <th>Price</th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Product obj : pList) { %>
                                    <tr>
                                        <td><%= obj.getId() %></td>
                                        <td><%= obj.getCategoryId() %></td>
                                        <td><%= obj.getName() %></td>
                                        <td><%= obj.getDescription() %></td>
                                        <td><%= obj.getDetail() %></td>
                                        <td>
                                            <img class="img-bordered" src="<%= obj.getThumbnail() %>" alt="." width="150px">
                                        </td>
                                        <td><%= obj.getPrice() %> đ</td>
                                        <td><a href="/admin/products/detail?id=<%= obj.getId() %>">Detail</a>&nbsp</td>
                                        <td><a href="/admin/products/edit?id=<%= obj.getId() %>">Edit</a>&nbsp</td>
                                        <td><a href="/admin/products/delete?id=<%= obj.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>&nbsp</td>
                                    </tr>
                                    <% } %>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>Category ID</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Detail</th>
                                        <th>Thumbnail</th>
                                        <th>Price</th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <div class="card-header">
                                <h3 class="card-title">Chef List</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Thumbnail</th>
                                        <th>Created At</th>
                                        <th>Updated At</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Chef obj : chList) { %>
                                    <tr>
                                        <td><%= obj.getId() %></td>
                                        <td><%= obj.getName() %></td>
                                        <td><%= obj.getDescription() %></td>
                                        <td>
                                            <img class="img-bordered" src="<%= obj.getThumbnail() %>" alt="." width="150px">
                                        </td>
                                        <td><%= obj.getCreatedAt() %></td>
                                        <td><%= obj.getUpdatedAt() %></td>
                                        <td>
                                            <a href="/admin/categories/detail?id=<%= obj.getId() %>">Detail</a>&nbsp;&nbsp;
                                            <a href="/admin/categories/edit?id=<%= obj.getId() %>">Edit</a>&nbsp;&nbsp;
                                            <a href="/admin/categories/delete?id=<%= obj.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
                                        </td>
                                    </tr>
                                    <% } %>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Thumbnail</th>
                                        <th>Created At</th>
                                        <th>Updated At</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="/admin/includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<jsp:include page="/admin/includes/script.jsp"></jsp:include>
</body>
</html>
