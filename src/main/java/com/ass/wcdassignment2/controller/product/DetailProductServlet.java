package com.ass.wcdassignment2.controller.product;

import com.ass.wcdassignment2.entity.Category;
import com.ass.wcdassignment2.model.CategoryModel;
import com.ass.wcdassignment2.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DetailProductServlet extends HttpServlet {

    private CategoryModel categoryModel;

    public DetailProductServlet() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAttribute("message"));
        List<Category> list = categoryModel.findAll();
        req.setAttribute("title", "List Category");
        req.setAttribute("list", list);
        req.getRequestDispatcher("/admin/categories/list.jsp").forward(req, resp);
    }
}
