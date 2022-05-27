package com.ass.wcdassignment2.controller.product;

import com.ass.wcdassignment2.entity.Category;
import com.ass.wcdassignment2.entity.Product;
import com.ass.wcdassignment2.entity.myenum.CategoryStatus;
import com.ass.wcdassignment2.entity.myenum.ProductStatus;
import com.ass.wcdassignment2.model.CategoryModel;
import com.ass.wcdassignment2.model.MySqlCategoryModel;
import com.ass.wcdassignment2.model.MySqlProductModel;
import com.ass.wcdassignment2.model.ProductModel;
import com.github.javafaker.Cat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class EditProductServlet extends HttpServlet {

    private ProductModel productModel;
    private CategoryModel categoryModel;

    public EditProductServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        if (product == null){
            req.setAttribute("message","Data not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req,resp);
        }else {
            req.setAttribute("title", "Product Management");
            req.setAttribute("list", productModel.findAll());
            req.setAttribute("categories", categoryModel.findAll());
            req.setAttribute("obj", product);
            req.setAttribute("action",2);
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        int categoyID = Integer.parseInt(req.getParameter("categoryId"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        double price = Double.parseDouble(req.getParameter("price"));
        String thumbnail = req.getParameter("thumbnail");
        int status = Integer.parseInt(req.getParameter("status"));
        Product product = new Product();
        product.setCategoryId(categoyID);
        product.setName(name);
        product.setDescription(description);
        product.setDetail(detail);
        product.setThumbnail(thumbnail);
        product.setPrice(price);
        product.setUpdatedAt(LocalDateTime.now());
        product.setStatus(ProductStatus.of(status));

        if (!product.isValid()){
            req.setAttribute("obj", product);
            req.setAttribute("action",2);
            req.setAttribute("title","Product Management");
            req.setAttribute("errors",product.getErrors());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
        }

        if (productModel.update(id, product) != null){
            resp.sendRedirect("/admin/products/list");
        }else {
            req.setAttribute("obj", product);
            req.setAttribute("action",2);
            req.setAttribute("title","Product Management");
            req.setAttribute("errors",product.getErrors());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
        }
    }
}

