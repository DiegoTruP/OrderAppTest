package com.foodorderingapplication.FoodOrderApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodorderingapplication.FoodOrderApp.dto.ResponseDTO;
import com.foodorderingapplication.FoodOrderApp.dto.StoreDetails;
import com.foodorderingapplication.FoodOrderApp.dto.StoreResponseDTO;
import com.foodorderingapplication.FoodOrderApp.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	StoreService storeService;
	
	@GetMapping("/stores")
	public ResponseEntity<StoreResponseDTO> getAllStores(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize){
		
		
		
		List<StoreDetails> storeDetailsList = storeService.getAllStoreDetails(pageNo,pageSize);
		
		StoreResponseDTO storeResponse =  new StoreResponseDTO("List generated", 200);
		
		storeResponse.setStoreList(storeDetailsList);
		
		return new ResponseEntity<StoreResponseDTO>(storeResponse, HttpStatus.OK);
	}
	
}
