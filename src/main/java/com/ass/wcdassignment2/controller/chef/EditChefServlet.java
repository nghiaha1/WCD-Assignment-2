package com.ass.wcdassignment2.controller.chef;

import com.ass.wcdassignment2.entity.Category;
import com.ass.wcdassignment2.entity.Chef;
import com.ass.wcdassignment2.entity.myenum.CategoryStatus;
import com.ass.wcdassignment2.entity.myenum.ChefStatus;
import com.ass.wcdassignment2.model.CategoryModel;
import com.ass.wcdassignment2.model.ChefModel;
import com.ass.wcdassignment2.model.MySqlCategoryModel;
import com.ass.wcdassignment2.model.MySqlChefModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class EditChefServlet extends HttpServlet {

    private ChefModel chefModel;

    public EditChefServlet() {
        this.chefModel = new MySqlChefModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Chef chef = chefModel.findById(id);
        List<Chef> list = chefModel.findAll();
        if (chef == null){
            req.setAttribute("message","Data not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req,resp);
        }else {
            req.setAttribute("title", "Edit Category");
            req.setAttribute("list", list);
            req.setAttribute("obj", chef);
            req.setAttribute("action",2);
            req.getRequestDispatcher("/admin/chefs/form.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String thumbnail = req.getParameter("thumbnail");
        int status = Integer.parseInt(req.getParameter("status"));
        Chef obj = new Chef();
        obj.setId(id);
        obj.setName(name);
        obj.setDescription(description);
        obj.setThumbnail(thumbnail);
        obj.setUpdatedAt(LocalDateTime.now());
        obj.setStatus(ChefStatus.of(status));

        if (!obj.isValid()){
            req.setAttribute("obj", obj);
            req.setAttribute("action",2);
            req.setAttribute("title","Edit Category");
            req.setAttribute("errors",obj.getErrors());
            req.getRequestDispatcher("/admin/chefs/form.jsp").forward(req,resp);
        }
        if (chefModel.update(id, obj) != null){
            resp.sendRedirect("/admin/chefs/list");
        }else {
            req.setAttribute("obj", obj);
            req.setAttribute("action",2);
            req.setAttribute("title","Edit Category");
            req.setAttribute("errors",obj.getErrors());
            req.getRequestDispatcher("/admin/chefs/form.jsp").forward(req,resp);
        }
    }
}

