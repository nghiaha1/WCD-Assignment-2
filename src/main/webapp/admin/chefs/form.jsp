<%@ page import="java.util.HashMap" %>
<%@ page import="com.ass.wcdassignment2.entity.Category" %>
<%@ page import="com.ass.wcdassignment2.entity.myenum.CategoryStatus" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ass.wcdassignment2.entity.Chef" %>
<%@ page import="com.ass.wcdassignment2.entity.myenum.ChefStatus" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Chef> list = (List<Chef>) request.getAttribute("list");
    Chef obj = (Chef) request.getAttribute("obj");
    if (obj == null) {
        obj = new Chef();
    }
    int action = (int) request.getAttribute("action");
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    String url = "/admin/chefs/create";
    if(action == 2) {
        url = "/admin/chefs/edit";
    }
    if (errors == null) {
        errors = new HashMap<>();
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
                        <h1>Product management</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/products/list">Product Management</a></li>
                            <li class="breadcrumb-item active">Create new</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <%
                    if (errors != null && errors.size() > 0){
                %>
                <div class="row">
                    <div class="col-12">
                        <div class="callout callout-danger">
                            <h5>Please fix error below</h5>
                            <ul>
                            <%
                                for (String msg: errors.values()){
                            %>
                                <li class="text-danger"><%= msg %></li>
                            <%
                                }
                            %>
                            </ul>
                        </div>
                    </div>
                </div>
                <% } %>
                <div class="row">
                    <div class="col-12">
                        <div class="card card-warning">
                            <div class="card-header">
                                <h3 class="card-title">Please enter information below</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <form action="<%= url %>" method="post" name="product-form">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <!-- text input -->
                                            <div class="form-group">
                                                <input type="hidden" name="id" value="<%= obj.getId() %>" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <!-- text input -->
                                            <div class="form-group">
                                                <label>Name</label>
                                                <input type="text" name="name" value="<%= obj.getName() %>" class="form-control" placeholder="Please enter name">
                                                <% if (errors.containsKey("name")) { %>
                                                    <span class="text-danger">* <%= errors.get("name") %></span>
                                                <% } %>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label>Description</label>
                                                <input type="text" name="description" value="<%= obj.getDescription() %>" class="form-control" placeholder="Please enter product's description">
                                                <% if (errors.containsKey("description")) { %>
                                                <span class="text-danger">* <%= errors.get("description") %></span>
                                                <% } %>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label>Thumbnail</label>
                                                <div class="input-group">
                                                    <div class="custom-file">
                                                        <input type="text" name="thumbnail" value="<%= obj.getThumbnail() %>" class="form-control" placeholder="Please enter product's thumbnail">
                                                    </div>
                                                    <div class="input-group-append" id="upload_widget">
                                                        <span class="input-group-text">Upload</span>
                                                    </div>
                                                </div>
                                                <img src="" alt="." style="display: none" sizes="200px" id="preview-img" class="img-bordered mt-2">
                                                <% if (errors.containsKey("thumbnail")) { %>
                                                <span class="text-danger">* <%= errors.get("thumbnail") %></span>
                                                <% } %>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label>Status</label>
                                                <select name="status" class="form-control">
                                                    <%
                                                        for (int i = 0; i < ChefStatus.values().length; i++) {
                                                    %>
                                                    <option <%= obj.getStatus() == ChefStatus.values()[i] ? "selected": "" %> value="<%= ChefStatus.values()[i].getValue() %>"><%= ChefStatus.values()[i].name() %></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <button class="btn btn-primary">Save</button>
                                                <input type="reset" class="btn btn-default" value="Reset">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- /.card-body -->
                        </div>
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
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
<script>
    document.addEventListener('DOMContentLoaded', function (){
        $('#summernote').summernote();
        var myWidget = cloudinary.createUploadWidget({
                cloudName: 'dab9sgwgk',
                uploadPreset: 'hgbett7h'}, (error, result) => {
                if (!error && result && result.event === "success") {
                    console.log('Done! Here is the image info: ', result.info.secure_url);
                    document.forms['product-form']['thumbnail'].value = result.info.secure_url;
                    document.getElementById('preview-image').src = result.info.secure_url;
                    document.getElementById('preview-image').style.display = "block";
                }
            }
        )

        document.getElementById("upload_widget").addEventListener("click", function(){
            myWidget.open();
        }, false);
    })
</script>
</body>
</html>