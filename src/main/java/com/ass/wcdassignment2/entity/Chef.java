package com.ass.wcdassignment2.entity;

import com.ass.wcdassignment2.entity.base.BaseEntity;
import com.ass.wcdassignment2.entity.myenum.ChefStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Chef extends BaseEntity {

    private int id; // String id UUID
    private String name; // slug
    private String description;
    private String thumbnail;
    private ChefStatus status;

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValidate();
        return errors.size() == 0;
    }

    private void checkValidate(){
        if (name == null || name.length() == 0 || name.length() <= 7) {
            errors.put("name", "Please enter name");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter description");
        }
        if (thumbnail == null || thumbnail.length() == 0) {
            errors.put("thumbnail", "Please choose thumbnail");
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", status=" + status +
                '}';
    }

    public Chef() {
        this.name = "";
        this.description = "";
        this.thumbnail = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ChefStatus.ACTIVE;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public ChefStatus getStatus() {
        return status;
    }

    public void setStatus(ChefStatus status) {
        this.status = status;
    }
}
