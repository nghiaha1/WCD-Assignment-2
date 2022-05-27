package com.ass.wcdassignment2.controller.chef;

import com.ass.wcdassignment2.entity.Chef;
import com.ass.wcdassignment2.entity.myenum.ChefStatus;
import com.ass.wcdassignment2.model.ChefModel;
import com.ass.wcdassignment2.model.MySqlChefModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateChefServlet extends HttpServlet {

    private ChefModel chefModel;

    public CreateChefServlet() {
        this.chefModel = new MySqlChefModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trả về form.
        req.setAttribute("obj", new Chef());
        req.setAttribute("title", "Add New Chef");
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/chefs/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String thumbnail = req.getParameter("thumbnail");
        int status = Integer.parseInt(req.getParameter("status"));
        Chef obj = new Chef();
        obj.setName(name);
        obj.setDescription(description);
        obj.setThumbnail(thumbnail);
        obj.setStatus(ChefStatus.of(status));
        if (chefModel.findByName(name) != null) {
            obj.addErrors("name", "Chef is already existed");
        }
        if (!obj.isValid()) {
            req.setAttribute("obj", obj);
            req.setAttribute("action", 1);
            req.setAttribute("errors", obj.getErrors());
            req.getRequestDispatcher("/admin/chefs/form.jsp").forward(req, resp);
            return;
        }
        if (chefModel.save(obj) != null) {
            resp.sendRedirect("/admin/chefs/list");
        } else {
            req.setAttribute("action", 1);
            req.setAttribute("title", "Add New Chef");
            req.getRequestDispatcher("/admin/chefs/form.jsp").forward(req, resp);
        }
    }
}
