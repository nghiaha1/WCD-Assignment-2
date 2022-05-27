package com.ass.wcdassignment2.controller.product;

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
import java.util.List;

public class ListProductUserServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;

    public ListProductUserServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> pList = productModel.findAll();
        List<Product> priceFilter = productModel.findAll();
        List<Category> cList = categoryModel.findAll();
        req.setAttribute("cList", cList);
        req.setAttribute("pList", pList);
        req.getRequestDispatcher("/user/pages/products.jsp").forward(req, resp);
    }
}
