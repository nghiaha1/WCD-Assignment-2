package com.ass.wcdassignment2.controller.chef;

import com.ass.wcdassignment2.entity.Chef;
import com.ass.wcdassignment2.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailChefServlet extends HttpServlet {

    private ChefModel chefModel;

    public DetailChefServlet() {
        this.chefModel = new MySqlChefModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Chef obj = chefModel.findById(id);
        if (obj == null) {
            req.setAttribute("message", "Chef not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            req.setAttribute("obj", obj);
            req.setAttribute("title", "Chef's Detail");
            req.getRequestDispatcher("/admin/chefs/detail.jsp").forward(req, resp);
        }
    }
}
