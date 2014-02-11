package com.practice.exercise005.isking235.vo;

/**
 * @author Administrator
 *
 */
public class Product {
	
	public Product(){
		super();
	}
	
	public Product(String productId, String productName, int price, int count) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.count = count;
	}
	

	/**
	 * 상품번호
	 */
	private String productId;
	
	/**
	 * 상품명
	 */
	private String productName;
	
	/**
	 * 판매가격
	 */
	private int price;
	
	/**
	 * 수량
	 */
	private int count;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	
}
