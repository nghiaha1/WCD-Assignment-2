package com.ass.wcdassignment2.model;

import com.ass.wcdassignment2.entity.Chef;

import java.util.List;

public interface ChefModel {
    Chef save(Chef obj); // lưu thông tin.

    List<Chef> findAll();

    Chef findById(int id);

    Chef findByName(String name);

    Chef update(int id, Chef updateObj);

    boolean delete(int id);
}
