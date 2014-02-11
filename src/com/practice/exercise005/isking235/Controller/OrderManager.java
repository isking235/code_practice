package com.practice.exercise005.isking235.Controller;

import java.util.ArrayList;

import com.practice.exercise005.isking235.exception.SoldOutException;
import com.practice.exercise005.isking235.vo.Product;

public class OrderManager {
	/**
	 *  주문상품 저장 
	 */
	private ArrayList<Product> orderList = new ArrayList<Product>();
	/**
	 * 주문금액
	 */
	private int orderAmt=0;
	/**
	 * 배송금액
	 */
	private int deliveryAmt=0; 
	/**
	 * 지불금액
	 */
	private int payAmt=0;
	
	public ArrayList<Product> getOrderList() {
		return orderList;
	}
	
	
	public int getOrderAmt() {
		return orderAmt;
	}


	public int getDeliveryAmt() {
		return deliveryAmt;
	}


	public int getPayAmt() {
		return payAmt;
	}


	/**
	 * 주문내역을 저장한다.
	 * @param orderItem
	 */
	private void setOrder(Product orderItem) {
		//주문번호가 중복 되는지 검사
		int check =0;
		for(Product itemProduct : this.orderList){
			if(itemProduct.getProductId().equals(orderItem.getProductId())){
				check ++;
			}
		}
		if(check ==0){
			this.orderList.add(orderItem);
			this.calcOrderAmt();
		}
		else {
			System.out.println("상품이 중복 됩니다.");
		}
	}
	
	/**
	 * 주문 직후 주문금액, 배송비 계산
	 */
	private void calcOrderAmt(){
		int amt = 0;
		for(Product orderItem : this.orderList){
			amt += orderItem.getPrice()*orderItem.getCount();
		}
		this.orderAmt = amt;
		if(amt > 50000){
			this.deliveryAmt = 0;
		}else {
			this.deliveryAmt = 5000;
		}
	}
	
	/**
	 * 지불금액 계산
	 */
	private void calcPayAmt(){
		this.payAmt = this.orderAmt;
		if(this.deliveryAmt > 0){ //배송료가 있는경우 합쳐준다.
			this.payAmt += this.deliveryAmt;
		}
	}
	
	/**
	 * 주문을 수행한다.
	 * @param productId 상품번호
	 * @param count 구매수량
	 */
	public void BuyProduct(String productId,String countParam){
		if("".equals(productId) || "".equals(countParam)){
			return;
		}
		int count = Integer.parseInt(countParam);
		
		if(this.orderList == null){
			this.orderList = new ArrayList<Product>();
		}
		
		ProductManager productMgr = ProductManager.getInstance();//보유상품 객체호출 
		Product product = productMgr.getItem(productId); //해당 ID의 보유 상품을 호출
		if(product != null){
			Product orderItem = new Product(product.getProductId(), 
					                        product.getProductName(),
					                        product.getPrice(),
					                        count);//주문상품을 만든다.
			this.setOrder(orderItem); //구입한 물품을 주문내역에 저장한다.
			
		}
		else {
			System.out.println("상품번호와 일치하는 물품이 없습니다.");
		}
	}
	
	/**
	 * 주문한 상품들을 결제 한다.
	 */
	public void purchaseProduct() throws SoldOutException{
		
		ProductManager productMgr = ProductManager.getInstance();//보유상품 객체호출
		
		if(this.orderList == null || this.orderList.size() ==0){
			System.out.println("주문한 내역이 없습니다.");
		}
		else{
			//1.재고량 있는지 검사
			for(Product orderItem : this.orderList){
				productMgr.reCalcItemCount(orderItem.getProductId(), orderItem.getCount());
			}//for end
			
		}//else end
		this.calcPayAmt(); //지불금액을 저장
		
	}
	/**
	 * 주문내역을 출력한다.
	 * @return 주문내역
	 */
	public String printOrderList(){
		StringBuffer message = new StringBuffer();
		message.append("주문내역:\n");
		message.append("-------------------------------\n");
		for(Product item : this.orderList){
			message.append(item.getProductName()).append(" - ")
			       .append(item.getCount()).append("\n");
		}
		if(this.deliveryAmt > 0){
			message.append("배송금액:").append(this.deliveryAmt).append("\n");
		}
		message.append("-------------------------------\n");
		message.append("주문금액:").append(this.orderAmt).append("\n");
		message.append("-------------------------------\n");
		message.append("지불금액:").append(this.payAmt).append("\n");
		message.append("-------------------------------\n");
		return message.toString();
	}
	
	public void orderReset(){
		this.orderList = new ArrayList<Product>();
	}
}
