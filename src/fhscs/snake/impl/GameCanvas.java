package fhscs.snake.impl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import fhscs.snake.Game;
import fhscs.snake.Snake;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas {

    private final Game game;
    private final ColorPalette palette;
    
    private BufferedImage buffImg;
    private Graphics buffG;
    private Dimension dim;
    
    public static final int blockSize = 15;
    
    public GameCanvas(Game game){
        this.game = game;
        this.palette = new ColorPalette();
        dim = this.getSize();
        buffImg = new BufferedImage(600,600, BufferedImage.TYPE_INT_RGB);
        buffG = buffImg.getGraphics();
        
        
        //this.setBackground(palette.BACKGROUND);
    }
    
    public ColorPalette getPalette(){
		return palette;
    }
    
    @Override
    public void paint(Graphics g) {
       
    	/*
    	drawApple(g);
    	drawSnake(g);
    	drawBoard(g);
    	*/
    	
    	drawBackground(buffG);
        drawBoard(buffG);
    	drawApple(buffG);
        drawSnake(buffG);
        drawBoard(buffG);
        g.drawImage(buffImg, 0, 0, this);
        
       // System.out.println("rep");
    }
    
    /**
     * Draws the {@link Snake}
     */
    private void drawSnake(Graphics g) {
      /*
    	for (Point p : game.getSnake().getLocations()) {
            fillBlock(g, palette.SNAKE, p);
        }
        */
    	Point p = new Point(game.getSnake().getHead());
    	fillBlock(g, Color.BLACK, p);
    	
    	for(int i = 0; i < game.getSnake().getLocations().size()-1; i++){
    		p = game.getSnake().getLocations().get(i);
    		fillBlock(g, palette.SNAKE, p);
    	}
    }
    
    /**
     * 
     * draws the background
     */
    private void drawBackground(Graphics g){
    	buffG.setColor(Color.LIGHT_GRAY);
        buffG.fillRect(0, 0, 600, 600);
        buffG.setColor(Color.WHITE);
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
    	g.setColor(Color.BLACK);
    	
    	g.drawRect(blockSize, blockSize, (game.getBoard().getWidth()*(blockSize))+(blockSize), (game.getBoard().getHeight()*(blockSize))+(blockSize));
    	
    	g.drawString("Score", (game.getBoard().getWidth()*blockSize) - 2*blockSize, (game.getBoard().getHeight()*blockSize) - 2*blockSize);
    	g.drawString(String.valueOf(game.getBoard().getScore()), (game.getBoard().getWidth()*blockSize), (game.getBoard().getHeight()*blockSize));
    	
    	g.drawString("HighScore", 2*blockSize, (game.getBoard().getHeight()*blockSize) - 2*blockSize);
    	g.drawString( String.valueOf(game.getBoard().getHighScore()), 2*blockSize, (game.getBoard().getHeight()*blockSize));
   
    }
    
    private void fillBlock(Graphics g, Color color, Point point) {
        Color before = g.getColor();
        g.setColor(color);
        g.fillRect((blockSize * point.x) + blockSize, (blockSize * point.y) + blockSize, blockSize, blockSize);
        g.setColor(before);
    }
    
}
