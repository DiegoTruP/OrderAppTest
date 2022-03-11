package com.foodorderingapplication.FoodOrderApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorderingapplication.FoodOrderApp.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer>{

}
