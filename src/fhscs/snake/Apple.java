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

	void eatApple(Snake snake);
	
}
