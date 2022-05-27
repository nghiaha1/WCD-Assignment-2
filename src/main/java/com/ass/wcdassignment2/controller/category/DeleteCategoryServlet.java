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

public class DeleteCategoryServlet extends HttpServlet {

    private CategoryModel categoryModel;

    public DeleteCategoryServlet() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham số rollNumber(id)
        int id = Integer.parseInt(req.getParameter("id"));
        // kiểm tra trong database xem có tồn tại không.
        Category category = categoryModel.findById(id);
        // nếu không trả về trang 404
        if (category == null) {
            req.setAttribute("message", "Category not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            boolean result = categoryModel.delete(id); // xoá mềm.
            if (result) {
                resp.sendRedirect("/admin/categories/list");
            } else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/admin/errors/500.jsp").forward(req, resp);
            }
        }
    }
}
