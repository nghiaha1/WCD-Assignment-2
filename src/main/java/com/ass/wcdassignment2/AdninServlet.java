package com.ass.wcdassignment2;

import com.ass.wcdassignment2.entity.Chef;
import com.ass.wcdassignment2.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdninServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;
    private ChefModel chefModel;

    public AdninServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
        this.chefModel = new MySqlChefModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cList", categoryModel.findAll());
        req.setAttribute("pList", productModel.findAll());
        req.setAttribute("chList", chefModel.findAll());
        req.setAttribute("title", "Admin Management");
        req.getRequestDispatcher("/admin/admin.jsp").forward(req, resp);
    }
}
