package com.ass.wcdassignment2;

import com.ass.wcdassignment2.model.ChefModel;
import com.ass.wcdassignment2.model.MySqlChefModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AboutServlet extends HttpServlet {
    private ChefModel chefModel;

    public AboutServlet() {
        this.chefModel = new MySqlChefModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("chList", chefModel.findAll());
        req.setAttribute("title", "About");
        req.getRequestDispatcher("/user/pages/about.jsp").forward(req, resp);
    }
}
