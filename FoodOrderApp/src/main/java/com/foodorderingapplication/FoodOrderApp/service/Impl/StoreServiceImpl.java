package com.foodorderingapplication.FoodOrderApp.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foodorderingapplication.FoodOrderApp.dto.StoreDetails;
import com.foodorderingapplication.FoodOrderApp.entity.Store;
import com.foodorderingapplication.FoodOrderApp.repository.StoreRepository;
import com.foodorderingapplication.FoodOrderApp.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;
	
	@Override
	public List<StoreDetails> getAllStoreDetails(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		//PageRequest.of(pageNo, pageSize);
		
		Page<Store> storePage =  storeRepository.findAll(paging);
		
		List<Store> storeList = storePage.getContent(); 
		
		List<StoreDetails> storeDetailsList =  storeList.stream().map(store -> {
			StoreDetails storeDetails = new StoreDetails();
			BeanUtils.copyProperties(store, storeDetails);
			return storeDetails;
		}).collect(Collectors.toList());
		return storeDetailsList;
	}
	
}
