package com.in28minutes.spring.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {

	public void up() {
		System.out.println("Pac-Man up");
	}
	
	public void down() {
		System.out.println("Pac-Man down");
	}
	
	public void left() {
		System.out.println("Pac-Man left");
	}
	
	public void right() {
		System.out.println("Pac-Man right");
	}
}
