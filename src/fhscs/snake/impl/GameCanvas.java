package fhscs.snake.impl;

import java.awt.Canvas;
import java.awt.Graphics;

import fhscs.snake.Game;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas {

    private final Game game;
    
    public GameCanvas(Game game) {
        this.game = game;
    }
    
    @Override
    public void paint(Graphics g) {
        drawSnake(g);
        drawApple(g);
        drawBoard(g);
    }
    
    /**
     * Draws the {@link Snake}
     */
    private static void drawSnake(Graphics g) {
        
    }
    
    /**
     * Draws the Apple
     */
    private static void drawApple(Graphics g) {
        
    }
    
    /**
     * Draws the {@link Board}
     */
    private static void drawBoard(Graphics g) {
        
    }
    
}
