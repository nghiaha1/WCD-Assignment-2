package com.ass.wcdassignment2;

import com.ass.wcdassignment2.entity.Category;
import com.ass.wcdassignment2.entity.Chef;
import com.ass.wcdassignment2.entity.Product;
import com.ass.wcdassignment2.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;
    private ChefModel chefModel;

    public HomeServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
        this.chefModel = new MySqlChefModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product products = new Product();
        Category categories = new Category();
        Chef chefs = new Chef();
        req.setAttribute("pList", productModel.findAll());
        req.setAttribute("cList", categoryModel.findAll());
        req.setAttribute("chList", chefModel.findAll());
        req.setAttribute("pObj", products);
        req.setAttribute("cObj", categories);
        req.setAttribute("chObj", chefs);
        req.setAttribute("title", "Restoran");
        req.getRequestDispatcher("/user/pages/home.jsp").forward(req, resp);
    }
}
