package com.in28minutes.spring.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.spring.learnspringframework.enterprise.example.web.MyWebController;
import com.in28minutes.spring.learnspringframework.game.GameRunner;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		
//		GamingConsole marioGame = new MarioGame();
//		GamingConsole batmanGame = new BatmanGame();
//		GamingConsole scgGame = new SuperContraGame();
//		GamingConsole pacmanGame = new PacmanGame();
//		
//		GameRunner marioRunner = new GameRunner(marioGame);
//		GameRunner batmanRunner = new GameRunner(batmanGame);
//		GameRunner scgRunner = new GameRunner(scgGame);
//		GameRunner pacmanRunner = new GameRunner(pacmanGame);
		
		ConfigurableApplicationContext context 
		= SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());

		
	}

}
