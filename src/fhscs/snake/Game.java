package fhscs.snake;

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
    Apple getApple();
    
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
    
    /**
     * Start or stop the game. If it's already in the passed state,
     * nothing happens.
     * 
     * @param running the new state
     */
    void setRunning(boolean running);
    
    /**
     * pauses the game
     */
    void pauseGame();
    
    /**
     * unpauses the game
     */
    void resumeGame();
    
    /**
     * 
     * @return state of paused
     */
    boolean isPaused();
    
    /**
     * 
     * @param paused
     */
    void setPaused(boolean paused);
    
}
