package fhscs.snake;

import java.awt.Point;

/**
 * Represents a game of classic Snake
 */
public interface Game {

    /**
     * 
     * @return the {@link Snake} object for this game controlled by the player
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
     * 
     * @return the current score
     */
    int getScore();
    
    /**
     * Increments the score by 1
     */
    void incrementScore();
    
    /**
     * Decrements the score by 1
     */
    void decrementScore();
    
    /**
     * Increments the score by the given amount
     * 
     * @param amount the amount to increment by
     */
    void incrementScore(int amount);
    
    /**
     * Decrements the score by the given amount
     * 
     * @param amount the amount to decrement by
     */
    void decrementScore(int amount);
    
    /**
     * Sets the score to the current value
     * 
     * @param score the new score
     */
    void setScore(int score);
    
    /**
     * Get whether or not the game is running.
     * 
     * @return true if the game is running, false otherwise
     */
    boolean isRunning();
    
    /**
     * Start or stop the game. If it's already in the passed state,
     * nothing happens.
     * 
     * @param running the new state
     */
    void setRunning(boolean running);
    
}
