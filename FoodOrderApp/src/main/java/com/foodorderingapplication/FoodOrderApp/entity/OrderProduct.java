package com.foodorderingapplication.FoodOrderApp.entity;

import javax.persistence.Embeddable;

@Embeddable
public class OrderProduct {
	
	private Integer productId;
	private Integer quantity;
	private Double productPrice;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

}
