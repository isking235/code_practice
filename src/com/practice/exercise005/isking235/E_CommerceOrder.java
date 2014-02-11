package com.practice.exercise005.isking235;

import java.util.Scanner;

import com.practice.exercise005.isking235.Controller.OrderManager;
import com.practice.exercise005.isking235.Controller.ProductManager;
import com.practice.exercise005.isking235.exception.SoldOutException;

public class E_CommerceOrder {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String keyInData = null;
		//1. 주문 배송 테스트
		ProductManager productMgr= ProductManager.getInstance(); //보유상품을 셋팅
		
		//System.out.println(productMgr.toString());
		//2. 사용자 입력을 기다린다.
		
		
		while(true){
			System.out.println("입력(o[order]:주문, q[quit]:종료):");
			
			keyInData = sc.nextLine();
			System.out.println(keyInData);
			
			if("q".equals(keyInData)){
				System.out.println("사용해 주셔서 감사합니다.");
				break;
			}
			if("o".equals(keyInData)){
				callOrderFunction();
			}
		}

	}
	/**
	 *　상품 입력 받음
	 */
	public static void callOrderFunction(){
		
		OrderManager orderMgr = new OrderManager();
		
		ProductManager productMgr= ProductManager.getInstance(); //보유상품을 셋팅
		System.out.println(productMgr.toString());
		
		Scanner scOrder = new Scanner(System.in);
		String productId = null;
		String count = null;
		while(true){
			System.out.println("상품번호:");
			productId = scOrder.nextLine();
			System.out.println("수량:");
			count = scOrder.nextLine();
			
			orderMgr.BuyProduct(productId, count);
			
			if("c".equals(productId)){
				System.out.println("주문을 다하지 않았습니다.");
				break;
			}
			if("".equals(productId)||"".equals(count)){
				
				try {
					orderMgr.purchaseProduct();
					System.out.println(orderMgr.printOrderList());
				} catch (SoldOutException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage()+"\n");
				}
				
					
				
				break;
			}
			
			
			
		}
		
	
	}

}
