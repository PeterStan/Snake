package fhscs.snake.impl;

import fhscs.snake.Game;

public class GameGraphics {

    private final Game game;
    
    public GameGraphics(Game game) {
        this.game = game;
    }
    
    /**
     * Updates the graphics
     */
    public void update() {
        drawBoard();
        drawSnake();
        drawApple();
    }
    
    /**
     * Draws the {@link Snake}
     */
    private static void drawSnake() {
        
    }
    
    /**
     * Draws the Apple
     */
    private static void drawApple() {
        
    }
    
    /**
     * Draws the {@link Board}
     */
    private static void drawBoard() {
        
    }
    
}
