package fhscs.snake;

import java.awt.Point;

public interface Apple {

	/**
	 * 
	 * @return location of apple
	 */
	Point getLocation();
	
	/**
	 * 
	 * @param front point of snake
	 */
	void eatApple(Snake snake);
	
	/**
	 * randomizes location of apple
	 */
	void newApple();
	
}
