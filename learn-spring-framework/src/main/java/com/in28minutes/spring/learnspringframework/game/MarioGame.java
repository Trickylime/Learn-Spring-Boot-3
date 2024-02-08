package com.in28minutes.spring.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {

	public void up() {
		System.out.println("jump");
	}
	
	public void down() {
		System.out.println("down in to pipe");
	}
	
	public void left() {
		System.out.println("stop");
	}
	
	public void right() {
		System.out.println("accelerate");
	}
}
