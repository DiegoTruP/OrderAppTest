package com.foodorderingapplication.FoodOrderApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorderingapplication.FoodOrderApp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
