package com.ass.wcdassignment2.model;

import com.ass.wcdassignment2.entity.Category;

import java.util.List;

public interface CategoryModel {
    Category save(Category obj); // lưu thông tin.

    List<Category> findAll();

    Category findById(int id);

    Category findByName(String name);

    Category update(int id, Category updateObj);

    boolean delete(int id);
}
