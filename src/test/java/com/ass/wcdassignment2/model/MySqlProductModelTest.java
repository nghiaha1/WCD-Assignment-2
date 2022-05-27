package com.ass.wcdassignment2.model;

import com.ass.wcdassignment2.entity.Chef;
import com.ass.wcdassignment2.entity.Product;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {
    private ProductModel productModel;
    private ChefModel chefModel;

    public MySqlProductModelTest() {
        this.productModel = new MySqlProductModel();
        this.chefModel = new MySqlChefModel();
    }

    public int getRandomNumberUsingNexInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min ) + min;
    }

    @Test
     void prepareData() {
        Faker faker = new Faker();
        for (int i = 0; i <= 40; i++) {
            Chef obj = new Chef();
            obj.setName(faker.name().title());
            obj.setDescription(faker.lorem().sentence());
            chefModel.save(obj);
        }
    }
}