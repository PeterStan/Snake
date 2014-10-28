package fhscs.snake;

import java.awt.Point;
import java.util.List;

public interface Snake {
    
    /**
     * Get the list of locations that compose the snake's body.
     * 
     * @return a list of points representing the locations the snake occupies
     */
    List<Point> getLocations();
    
    /**
     * 
     * @return the snake's current{@link Direction} of motion
     */
    Direction getDirection();
    
    /**
     * 
     * @return the location of the snake's head
     */
    Point getHead();
    
    /**
     * Set the {@link Direction} of the snake's motion
     * 
     * @param direction the new direction that the snake should move in
     */
    void setDirection(Direction direction);
    
    /**
     * Moves the snake one square in the direction of motion
     */
    void move();
    
}
