package fhscs.snake;

import java.awt.Point;

/**
 * Represents the board that the snake game plays on,
 * a grid of squares.
 * 
 * The bottom-left corner is (1,1), the top-right corner is (width, height)
 */
public interface Board {

    /**
     * 
     * @return the number of squares in the horizontal movement
     */
    int getWidth();
    
    /**
     * 
     * @return the number of squares in the vertical movement
     */
    int getHeight();
    
    /**
     * Checks whether a point is outside the grid or not.
     * 
     * @param point the point to check
     * @return true if the point is outside of the grid, false otherwise
     */
    boolean isOutside(Point point);
    
    /**
     * 
     * @param score
     */
    void setScore(int score);
    
    /**
     * 
     * @param incerase score by this amount
     */
    void incrementScore(int amount);
    
    /**
     * increase score
     */
    void incrementScore();

    /**
     * 
     * @return score
     */
    int getScore();
    
	/**
	 * 
	 * @param Score
	 */
	void logScore(int Score);
	
	/**
	 * 
	 * @return
	 */
	int readScoreLog();
}
