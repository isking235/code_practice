package com.practice.exercise005.isking235.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.practice.exercise005.isking235.Controller.OrderManager;
import com.practice.exercise005.isking235.Controller.ProductManager;
import com.practice.exercise005.isking235.exception.SoldOutException;

public class OrderManagerTest {

	
	
	@Test
	public void testPurchaseProduct() {
		//테스트계획?
		//1. 1개의 주문으로 구입하도록 한다.
		//2. 상품번호 : 24669991, 상풍명 : 가을맞이 모던큐트로퍼/플랫 원수량 : 9 주문수량 : 3
		//   상품번호 : 24661322, 상풍명 : 쿨제이 가을신상트랜디셔츠  원수량 : 2 주문수량 : 3
		
		ProductManager productMgr= ProductManager.getInstance(); //보유상품을 셋팅
		OrderManager orderMgr = new OrderManager();
		
		//System.out.println(productMgr.toString());//상품목록 출력
		orderMgr.BuyProduct("24669991", "3");
		orderMgr.BuyProduct("24661322", "3"); //에러가 나는 경우 
		//orderMgr.BuyProduct("24661322", "2"); //에러가 안 나는 경우
		
		System.out.println(orderMgr.getPayAmt()); //지불금액을 출력한다.
		
		Boolean result = false;
		try{
			orderMgr.purchaseProduct();
			result = true;
		} catch (SoldOutException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage()+"\n");
		}
		System.out.println(orderMgr.printOrderList()); //구입대기 중인 상품을 출력한다.
		//System.out.println(productMgr.toString());//상품목록 호출
		
		assertEquals(true, result);
	}
	
	

}
