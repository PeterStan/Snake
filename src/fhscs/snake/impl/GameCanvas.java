package fhscs.snake.impl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import fhscs.snake.Game;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas {

    private final Game game;

    private Color snakeColor = Color.GREEN;
    
    private Color appleColor = Color.RED;
    
    private static final int blockSize = 20;
    
    public GameCanvas(Game game) {
        this.game = game;
    }
    
    @Override
    public void paint(Graphics g) {
        drawSnake(g);
        drawApple(g);
    }
    
    /**
     * Draws the {@link Snake}
     */
    private void drawSnake(Graphics g) {
        for (Point p : game.getSnake().getLocations()) {
            fillBlock(g, snakeColor, p);
        }
    }
    
    /**
     * Draws the Apple
     */
    private void drawApple(Graphics g) {
        fillBlock(g, appleColor, game.getApple());
    }
    
    private void fillBlock(Graphics g, Color color, Point point) {
        Color before = g.getColor();
        g.setColor(color);
        g.fillRect((blockSize * point.x) + blockSize, (blockSize * point.y) + blockSize, 2*blockSize, 2*blockSize);
        g.setColor(before);
    }
    
    /**
     * Set the color of the snake.
     * 
     * @param c the color of the snake
     */
    public void setSnakeColor(Color c) {
    	this.snakeColor = c;
    }
    
    /**
     * Returns the color of the snake.
     * 
     * @return the color of the snake.
     */
    public Color getSnakeColor() { 	
    	return snakeColor;
    }

    /**
     * Returns the color of the apple.
     * 
     * @return the color of the apple
     */
	public Color getAppleColor() {
		return appleColor;
	}

	/**
	 * Set the color of the apple
	 * 
	 * @param appleColor the color of the apple
	 */
	public void setAppleColor(Color appleColor) {
		this.appleColor = appleColor;
	}
    
}
