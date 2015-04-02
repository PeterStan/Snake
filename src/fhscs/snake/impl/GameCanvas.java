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
    
    public static final int blockSize = 10;
    
    public GameCanvas(Game game) {
        this.game = game;
        this.palette = new ColorPalette();
        this.setBackground(palette.BACKGROUND);
    }
    
    @Override
    public void paint(Graphics g) {
        drawApple(g);
        drawSnake(g);
        drawBoard(g);
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
        fillBlock(g, palette.APPLE, game.getApple().getLocation());
    }
    
    /**
     * 
     * Draws the Board
     */
    private void drawBoard(Graphics g){
    	g.drawRect(blockSize, blockSize, (game.getBoard().getWidth()*(blockSize))+(2*blockSize), (game.getBoard().getHeight()*(blockSize))+(2*blockSize));
    	
    	g.drawString("Score", (game.getBoard().getWidth()*blockSize) - 2*blockSize, (game.getBoard().getHeight()*blockSize) - 2*blockSize);
    	g.drawString(String.valueOf(game.getBoard().getScore()), (game.getBoard().getWidth()*blockSize), (game.getBoard().getHeight()*blockSize));
    	
    	g.drawString("HighScore", 2*blockSize, (game.getBoard().getHeight()*blockSize) - 2*blockSize);
    	g.drawString( String.valueOf(game.getBoard().getHighScore()), 2*blockSize, (game.getBoard().getHeight()*blockSize));
    }
    
    private void fillBlock(Graphics g, Color color, Point point) {
        Color before = g.getColor();
        g.setColor(color);
        g.fillRect((blockSize * point.x) + blockSize, (blockSize * point.y) + blockSize, 2*blockSize, 2*blockSize);
        g.setColor(before);
    }
    
}
