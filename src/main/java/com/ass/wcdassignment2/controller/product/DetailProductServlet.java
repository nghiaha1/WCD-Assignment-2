package com.ass.wcdassignment2.controller.product;

import com.ass.wcdassignment2.entity.Category;
import com.ass.wcdassignment2.entity.Product;
import com.ass.wcdassignment2.model.CategoryModel;
import com.ass.wcdassignment2.model.MySqlCategoryModel;
import com.ass.wcdassignment2.model.MySqlProductModel;
import com.ass.wcdassignment2.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DetailProductServlet extends HttpServlet {

    private CategoryModel categoryModel;
    private ProductModel productModel;

    public DetailProductServlet() {
        this.categoryModel = new MySqlCategoryModel();
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product obj = productModel.findById(id);
        if (obj == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            req.setAttribute("obj", obj);
            req.setAttribute("title", "Product's Detail");
            req.getRequestDispatcher("/admin/products/detail.jsp").forward(req, resp);
        }
    }
}
