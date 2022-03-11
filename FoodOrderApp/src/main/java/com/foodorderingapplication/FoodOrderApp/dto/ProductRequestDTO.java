package com.foodorderingapplication.FoodOrderApp.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.foodorderingapplication.FoodOrderApp.entity.ProductCategory;
import com.foodorderingapplication.FoodOrderApp.entity.Store;

public class ProductRequestDTO {
	

	@Min(value = 1,message = "productId should be greater or equal to 1")
	private Integer productId;
	@Pattern(regexp = "[a-zA-Z0-9 -]*$")
	private String productName;
	@Min(value = 0, message = "productPrice should be greater or equal to 0")
	private double productPrice;
	private String productDescription;
	@NotNull(message = "storeId can't be null")
	@Min(value = 1, message = "storeId should be grater or equal to 0")
	private Integer storeId;
	private String productCategory;
	private Boolean isAvailable;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
