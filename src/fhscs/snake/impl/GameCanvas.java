package fhscs.snake.impl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import fhscs.snake.Game;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas {

    private final Game game;
    
    private final ColorPalette palette;
    
    private static final int blockSize = 20;
    
    public GameCanvas(Game game) {
        this.game = game;
        this.palette = new ColorPalette();
        this.setBackground(palette.BACKGROUND);
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
            fillBlock(g, palette.SNAKE, p);
        }
    }
    
    /**
     * Draws the Apple
     */
    private void drawApple(Graphics g) {
        fillBlock(g, palette.APPLE, game.getApple());
    }
    
    private void fillBlock(Graphics g, Color color, Point point) {
        Color before = g.getColor();
        g.setColor(color);
        g.fillRect((blockSize * point.x) + blockSize, (blockSize * point.y) + blockSize, 2*blockSize, 2*blockSize);
        g.setColor(before);
    }
    
}
