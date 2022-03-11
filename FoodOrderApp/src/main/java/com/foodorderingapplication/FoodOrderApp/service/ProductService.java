package com.foodorderingapplication.FoodOrderApp.service;

import org.springframework.stereotype.Service;

import com.foodorderingapplication.FoodOrderApp.dto.ProductRequestDTO;


public interface ProductService {

	void saveProductDetails(ProductRequestDTO productRequestDTO);

}
