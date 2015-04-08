package fhscs.snake;

import java.awt.Point;

public interface Apple {

	/**
	 * 
	 * @return location of apple
	 */
	Point getLocation();
	
	/**
	 * randomizes location of apple
	 */
	void newApple();

	/**
	 * checks if snake eats the apple, then makes a new apple
	 * @param snake
	 */
	void eatApple(Snake snake);

	/**
	 * randomizes the location of the apple but ensure the apple is not under the snake
	 * @param snake
	 */
	void newApple(Snake snake);
	
}
