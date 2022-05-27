package com.ass.wcdassignment2.entity;

import com.ass.wcdassignment2.entity.base.BaseEntity;
import com.ass.wcdassignment2.entity.myenum.CategoryStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Category extends BaseEntity {

    private int id;
    private String name;
    private CategoryStatus status;
    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValidate();
        return errors.size() == 0;
    }

    private void checkValidate() {
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public void addErrors(String key, String value) {
        if (this.errors == null) {
            this.errors = new HashMap<>();
        }
        this.errors.put(key, value);
    }
    public Category() {
        this.name = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = CategoryStatus.ACTIVE;
    }
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public Category(String name, CategoryStatus status) {
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = CategoryStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CategoryStatus getStatus() {
        return status;
    }

    public void setStatus(CategoryStatus status) {
        this.status = status;
    }
}
