package com.foodorderingapplication.FoodOrderApp.dto;

import java.util.ArrayList;
import java.util.List;

public class StoreResponseDTO extends ResponseDTO {
	
	public StoreResponseDTO(String message, Integer status) {
		super(message, status);
	}

	private List<StoreDetails> storeList = new ArrayList<StoreDetails>();

	public List<StoreDetails> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<StoreDetails> storeList) {
		this.storeList = storeList;
	}
}
