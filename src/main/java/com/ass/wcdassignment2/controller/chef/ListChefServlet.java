package com.ass.wcdassignment2.controller.chef;

import com.ass.wcdassignment2.entity.Category;
import com.ass.wcdassignment2.entity.Chef;
import com.ass.wcdassignment2.model.CategoryModel;
import com.ass.wcdassignment2.model.ChefModel;
import com.ass.wcdassignment2.model.MySqlCategoryModel;
import com.ass.wcdassignment2.model.MySqlChefModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListChefServlet extends HttpServlet {
    private ChefModel chefModel;

    public ListChefServlet() {
        this.chefModel = new MySqlChefModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Chef Management");
        req.setAttribute("list", chefModel.findAll());
        req.getRequestDispatcher("/admin/chefs/list.jsp").forward(req, resp);
    }
}
