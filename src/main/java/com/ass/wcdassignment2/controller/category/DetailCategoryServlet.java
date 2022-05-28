package com.ass.wcdassignment2.controller.category;

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

public class DetailCategoryServlet extends HttpServlet {

    private CategoryModel categoryModel;

    public DetailCategoryServlet() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category obj = categoryModel.findById(id);
        if (obj == null) {
            req.setAttribute("message", "Category not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            req.setAttribute("obj", obj);
            req.setAttribute("title", "Category's Detail");
            req.getRequestDispatcher("/admin/categories/detail.jsp").forward(req, resp);
        }
    }
}
