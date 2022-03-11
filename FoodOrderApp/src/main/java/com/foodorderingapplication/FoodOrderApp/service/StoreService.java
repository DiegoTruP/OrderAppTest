package com.foodorderingapplication.FoodOrderApp.service;

import java.util.List;

import com.foodorderingapplication.FoodOrderApp.dto.StoreDetails;

public interface StoreService {

	List<StoreDetails> getAllStoreDetails(Integer pageNo, Integer pageSize);

}
