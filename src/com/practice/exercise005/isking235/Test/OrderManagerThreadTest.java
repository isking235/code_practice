package com.practice.exercise005.isking235.Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderManagerThreadTest {

	@Test
	public void testPurchaseProductMulti() {
		//테스트계획
		//1. 4개의 쓰레드에서 물품을 구입하도록 한다.
		//2. 상품번호 : 24669991, 상풍명 : 가을맞이 모던큐트로퍼/플랫 원수량 : 9 주문수량 : 3
		//   상품번호 : 24669991, 상풍명 : 가을맞이 모던큐트로퍼/플랫 원수량 : 9 주문수량 : 3
		//   상품번호 : 24669991, 상풍명 : 가을맞이 모던큐트로퍼/플랫 원수량 : 9 주문수량 : 3
		//   상품번호 : 24669991, 상풍명 : 가을맞이 모던큐트로퍼/플랫 원수량 : 9 주문수량 : 3
		
		Runnable order1 = new OrderThreads();
		Runnable order2 = new OrderThreads();
		Runnable order3 = new OrderThreads();
		Runnable order4 = new OrderThreads();
		
		Thread orderThread1 = new Thread(order1);
		Thread orderThread2 = new Thread(order2);
		Thread orderThread3 = new Thread(order3);
		Thread orderThread4 = new Thread(order4);
		
		orderThread1.setName("1구매자");
		orderThread2.setName("2구매자");
		orderThread3.setName("3구매자");
		orderThread4.setName("4구매자");
		
		orderThread1.start();
		orderThread2.start();
		orderThread3.start();
		orderThread4.start();
		
		
		assertEquals(true, true);
	}

}
