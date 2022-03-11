package com.foodorderingapplication.FoodOrderApp.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer storeId;
	private String storeName;	
	private Address storeAddress;
	private float rating;	
	private String storeDescription;
	private LocalTime TopenTill;
	
	@OneToMany(mappedBy = "store")
	private List<Product> productList;	
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Address getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(Address storeAddress) {
		this.storeAddress = storeAddress;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public LocalTime getTopenTill() {
		return TopenTill;
	}
	public void setTopenTill(LocalTime topenTill) {
		TopenTill = topenTill;
	}
	
	
	
	public String getStoreDescription() {
		return storeDescription;
	}
	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

}
