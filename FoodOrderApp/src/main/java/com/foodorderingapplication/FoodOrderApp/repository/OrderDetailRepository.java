package com.foodorderingapplication.FoodOrderApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorderingapplication.FoodOrderApp.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{

	List<OrderDetail> findAllByUserId(Integer userId);
	

}
