package com.practice.exercise005.isking235.exception;

@SuppressWarnings("serial")
public class SoldOutException extends Exception {
	public SoldOutException(){
		super("재고물량이부족합니다.");
	}
	public SoldOutException(String message){
		super(message);
	}
}
