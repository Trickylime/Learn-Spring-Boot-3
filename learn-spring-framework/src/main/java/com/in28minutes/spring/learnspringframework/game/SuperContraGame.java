package com.in28minutes.spring.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements GamingConsole{

	public void up() {
		System.out.println("SCG Jump");
	}
	
	public void down() {
		System.out.println("SCG down");
	}
	
	public void left() {
		System.out.println("SCG left");
	}
	
	public void right() {
		System.out.println("SCG right");
	}
}
