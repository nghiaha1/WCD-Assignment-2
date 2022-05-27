package com.ass.wcdassignment2;

import com.ass.wcdassignment2.model.MySqlProductModel;
import com.ass.wcdassignment2.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MenuServlet extends HttpServlet {
    private ProductModel productModel;

    public MenuServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pList", productModel.findAll());
        req.setAttribute("title", "Menu");
        req.getRequestDispatcher("/user/pages/menu.jsp").forward(req, resp);
    }
}
