package com.ass.wcdassignment2.controller.product;

import com.ass.wcdassignment2.model.MySqlProductModel;
import com.ass.wcdassignment2.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ListProductServlet extends HttpServlet {

    private ProductModel productModel;

    public ListProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "List Product");
        req.setAttribute("list", productModel.findAll());
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req, resp);
    }
}
