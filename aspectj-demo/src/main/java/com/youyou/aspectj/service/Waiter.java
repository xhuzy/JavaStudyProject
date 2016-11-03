package com.youyou.aspectj.service;

public class Waiter {
	public void sayHello(String customerName) {
		System.out.println("Hello " + customerName);
	}

	public void service(String customer) {
		System.out.println("Hello " + customer + " ,I am privide service to you");
	}
}
