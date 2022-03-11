package com.foodorderingapplication.FoodOrderApp.service.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodorderingapplication.FoodOrderApp.dto.OrderDetailDTO;
import com.foodorderingapplication.FoodOrderApp.dto.OrderDetailRequestDTO;
import com.foodorderingapplication.FoodOrderApp.entity.OrderDetail;
import com.foodorderingapplication.FoodOrderApp.entity.OrderStatus;
import com.foodorderingapplication.FoodOrderApp.entity.Product;
import com.foodorderingapplication.FoodOrderApp.exceptions.MismatchingPriceException;
import com.foodorderingapplication.FoodOrderApp.repository.OrderDetailRepository;
import com.foodorderingapplication.FoodOrderApp.repository.ProductRepository;
import com.foodorderingapplication.FoodOrderApp.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public OrderDetailDTO saveOrderDetail(OrderDetailRequestDTO orderRequestDTO) {
		
		Boolean isPriceMatch =  orderRequestDTO.getOrderProductList().stream().allMatch(orderProduct -> {
							Optional<Product> product = productRepository.findById(orderProduct.getProductId());
							return product.get().getProductPrice()==orderProduct.getProductPrice();	
						});
		
		if(!isPriceMatch) {
			//Throw mismatching price error
			throw new MismatchingPriceException("Product mismatch price!");
		}
		
		Boolean isTotalMatch = orderRequestDTO.getOrderProductList().stream().map(product -> product.getProductPrice()*product.getQuantity())
											.reduce(0.0, (total,productTotal) -> total+productTotal ).equals(orderRequestDTO.getTotalPrice());
		
		if(!isTotalMatch) {
			//Throw mismatching total error
		}
		
		OrderDetail orderDetail = new OrderDetail();
		BeanUtils.copyProperties(orderRequestDTO, orderDetail);
		orderDetail.setOrderDate(LocalDate.now());
		orderDetail.setStatus(OrderStatus.PLACED);	
		
		orderDetail = orderDetailRepository.save(orderDetail);
		OrderDetailDTO orderDetailDto = new OrderDetailDTO();
		BeanUtils.copyProperties(orderDetail, orderDetailDto);
		
		return orderDetailDto;
		
	}

	@Override
	public List<OrderDetailDTO> getOrderDetailByUserId(Integer userId) {
		List<OrderDetail> orderDetailList = orderDetailRepository.findAllByUserId(userId);
		List<OrderDetailDTO> orderDetailDtoList = new ArrayList<OrderDetailDTO>();
		
		orderDetailDtoList = orderDetailList.stream().map(orderDetail -> {
			OrderDetailDTO orderDetailDto = new OrderDetailDTO();
			BeanUtils.copyProperties(orderDetail, orderDetailDto);
			return orderDetailDto;
		}).collect(Collectors.toList());
		
		
		return orderDetailDtoList;
	}

}
