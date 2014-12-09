package fhscs.snake.impl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import fhscs.snake.Game;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas {

    private final Game game;
    
    private static final int blockSize = 20;
    
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
    private void drawSnake(Graphics g) {
        
    }
    
    /**
     * Draws the Apple
     */
    private void drawApple(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(game.getApple().x + blockSize, game.getApple().y + blockSize, 2*blockSize, 2*blockSize);
    }
    
    /**
     * Draws the {@link Board}
     */
    private void drawBoard(Graphics g) {
        
    }
    
}
