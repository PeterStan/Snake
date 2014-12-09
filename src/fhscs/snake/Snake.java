package fhscs.snake;

import java.awt.Point;
import java.util.List;

public interface Snake {
    
    /**
     * 
     * @return the size of the snake
     */
    int getSize();
    
    /**
     * Get the list of locations that compose the snake's body.
     * 
     * @return a list of points representing the locations the snake occupies
     */
    List<Point> getLocations();
    
    /**
     * 
     * @return the snake's current{@link Movement} of motion
     */
    Movement getMovement();
    
    /**
     * 
     * @return the location of the snake's head
     */
    Point getHead();
    
    /**
     * Set the {@link Movement} of the snake's motion
     * 
     * @param movement the new movement that the snake should move in
     */
    void setMovement(Movement movement);
    
    /**
     * Moves the snake one square in the movement of motion
     */
    void move();
    
    /**
     * Elongate the snake by adding 1 block to its tail
     */
    void elongate();
    
    /**
     * Shorten the snake by removing 1 block from its tail
     */
    void shorten();
    
    /**
     * Elongate the snake by the given amount by adding blocks to its tail
     * 
     * @param amount the amount to elongate the snake by
     */
    void elongate(int amount);
    
    /**
     * Shorten the snake by the given amount by removing blocks from its tail
     * 
     * @param amount the amount to shorten the snake by
     */
    void shorten(int amount);
    
}
