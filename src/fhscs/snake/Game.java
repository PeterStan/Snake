package fhscs.snake;

import java.awt.Point;

public interface Game {

    /**
     * 
     * @return the {@link Snake} object for this game
     */
    Snake getSnake();
    
    /**
     * 
     * @return the current location of the apple being displayed on the screen
     */
    Point getApple();
    
    /**
     * 
     * @return the {@link Board} for this game
     */
    Board getBoard();
    
    /**
     * Get whether or not the game is running.
     * 
     * @return true if the game is running, false otherwise
     */
    boolean isRunning();
    
}
