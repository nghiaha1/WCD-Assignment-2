package com.ass.wcdassignment2.controller.chef;

import com.ass.wcdassignment2.entity.Product;
import com.ass.wcdassignment2.model.MySqlProductModel;
import com.ass.wcdassignment2.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteChefServlet extends HttpServlet {

    private ProductModel productModel;

    public DeleteChefServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham số rollNumber(id)
        int id = Integer.parseInt(req.getParameter("id"));
        // kiểm tra trong database xem có tồn tại không.
        Product product = productModel.findById(id);
        // nếu không trả về trang 404
        if (product == null) {
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            boolean result = productModel.delete(id); // xoá mềm.
            if (result) {
                resp.sendRedirect("/admin/chefs/list");
            } else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/admin/errors/500.jsp").forward(req, resp);
            }
        }
    }
}
