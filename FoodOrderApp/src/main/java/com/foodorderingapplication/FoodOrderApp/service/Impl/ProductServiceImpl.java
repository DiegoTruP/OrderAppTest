package com.foodorderingapplication.FoodOrderApp.service.Impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodorderingapplication.FoodOrderApp.dto.ProductRequestDTO;
import com.foodorderingapplication.FoodOrderApp.entity.Product;
import com.foodorderingapplication.FoodOrderApp.entity.ProductCategory;
import com.foodorderingapplication.FoodOrderApp.entity.Store;
import com.foodorderingapplication.FoodOrderApp.exceptions.StoreNotFoundException;
import com.foodorderingapplication.FoodOrderApp.repository.ProductRepository;
import com.foodorderingapplication.FoodOrderApp.repository.StoreRepository;
import com.foodorderingapplication.FoodOrderApp.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Override
	public void saveProductDetails(ProductRequestDTO productRequestDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productRequestDTO, product);
		product.setProductCategory(ProductCategory.valueOf(productRequestDTO.getProductCategory()));
		Optional<Store> storeOptional = storeRepository.findById(productRequestDTO.getStoreId());
		if(storeOptional.isEmpty()) {
			throw new StoreNotFoundException("Store Not Found : " + productRequestDTO.getStoreId());
		}
		
		productRepository.save(product);
		
	}

}
