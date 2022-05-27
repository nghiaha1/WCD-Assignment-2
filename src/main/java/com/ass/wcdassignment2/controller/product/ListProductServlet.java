package com.ass.wcdassignment2.controller.product;

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

public class ListProductServlet extends HttpServlet {

    private ProductModel productModel;
    private CategoryModel categoryModel;

    public ListProductServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAttribute("message"));
        req.setAttribute("title", "List Product");
        req.setAttribute("list", productModel.findAll());
        req.setAttribute("cList", categoryModel.findAll());
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req, resp);
    }
}
