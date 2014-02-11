package com.practice.exercise005.isking235.Test;

import com.practice.exercise005.isking235.Controller.OrderManager;
import com.practice.exercise005.isking235.Controller.ProductManager;
import com.practice.exercise005.isking235.exception.SoldOutException;

public class OrderThreads implements Runnable {
    
	ProductManager productMgr= ProductManager.getInstance(); //보유상품을 셋팅
	OrderManager orderMgr = new OrderManager();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			this.orderProduct();
		} catch (SoldOutException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String threadName = Thread.currentThread().getName();
			System.out.println(e.getMessage()+"구매자 이름 : "+threadName+"\n");
		}

	}
	
	public void orderProduct() throws SoldOutException{
		String threadName = Thread.currentThread().getName();
		orderMgr.BuyProduct("24669991", "3");
		orderMgr.purchaseProduct();
		System.out.println("구입 완료!! 구매자 이름 : "+threadName+"\n");
		System.out.println(orderMgr.printOrderList()); //구매내역 출력
		
	}

}
