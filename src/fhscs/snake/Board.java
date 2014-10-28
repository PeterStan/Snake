package fhscs.snake;

import java.awt.Point;

/**
 * Represents the board that the snake game plays on,
 * a grid of squares.
 */
public interface Board {

    /**
     * 
     * @return the number of squares in the horizontal direction
     */
    int getWidth();
    
    /**
     * 
     * @return the number of squares in the vertical direction
     */
    int getHeight();
    
    /**
     * Checks whether a point is outside the grid or not.
     * 
     * @param point the point to check
     * @return true if the point is outside of the grid, false otherwise
     */
    boolean isOutside(Point point);
    
}
