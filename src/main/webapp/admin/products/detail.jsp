<%@ page import="com.ass.wcdassignment2.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product obj = (Product) request.getAttribute("obj");
    if (obj == null) {
        obj = new Product();
    }
%>
<jsp:include page="/admin/includes/head.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/navbar.jsp"></jsp:include>

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/sidebar.jsp"></jsp:include>

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
                                <h3 class="card-title">DataTable with default features</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Category ID</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Detail</th>
                                        <th>Thumbnail</th>
                                        <th>Price</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><%= obj.getId() %></td>
                                        <td><%= obj.getCategoryId() %></td>
                                        <td><%= obj.getName() %></td>
                                        <td><%= obj.getDescription() %></td>
                                        <td><%= obj.getDetail() %></td>
                                        <td>
                                            <img class="img-bordered" src="<%= obj.getThumbnail() %>" alt="." width="150px">
                                        </td>
                                        <td><%= obj.getPrice() %></td>
                                        <td>
                                            <a href="/admin/products/edit?id=<%= obj.getId() %>">Edit</a>&nbsp;&nbsp;
                                            <a href="/admin/products/delete?id=<%= obj.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                        <th>ID</th>
                                        <th>Category ID</th>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Detail</th>
                                        <th>Thumbnail</th>
                                        <th>Price</th>
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

    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<jsp:include page="../includes/script.jsp"></jsp:include>
</body>
</html>
