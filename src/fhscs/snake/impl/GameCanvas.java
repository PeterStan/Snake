package fhscs.snake.impl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fhscs.snake.Game;
import fhscs.snake.Snake;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas {

    private final Game game;
    private final ColorPalette palette;
    
    private BufferedImage buffImg;
    private Graphics buffG;
    private Dimension dim = new Dimension();
    
    private BufferedImage dirt;
    private BufferedImage apple;
    private BufferedImage snake;
    private BufferedImage snakehead;
    
    public static final int blockSize = 15;
    
    public GameCanvas(Game game){
        this.game = game;
        this.palette = new ColorPalette();
        dim.setSize(600, 600);
        buffImg = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_RGB);
        buffG = buffImg.getGraphics();
        

        try {
			dirt = ImageIO.read(new File(System.getProperty("user.dir") + "\\attributes\\dirt1.jpg"));
			apple = ImageIO.read(new File(System.getProperty("user.dir") + "\\attributes\\apple.png"));
			snake = ImageIO.read(new File(System.getProperty("user.dir") + "\\attributes\\snake.png"));
			snakehead = ImageIO.read(new File(System.getProperty("user.dir") + "\\attributes\\snakehead.png"));
		} catch (IOException e) {
			System.out.println("Image File Not Found");
			e.printStackTrace();
		}
        
    }
    
    public ColorPalette getPalette(){
		return palette;
    }
    
    
    @Override
    public void paint(Graphics g) {;
    
    	drawBackground(buffG);
        drawBoard(buffG);
    	drawApple(buffG);
        drawSnake(buffG);
        
        g.drawImage(buffImg, 0, 0, this);
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
    		g.drawImage(snake, (int)(game.getSnake().getLocations().get(i).getX()*blockSize)+blockSize, (int)(game.getSnake().getLocations().get(i).getY()*blockSize)+blockSize, blockSize,blockSize, null);
    	}
    }
    
    /**
     * 
     * draws the background
     */
    private void drawBackground(Graphics g){
    	/*
    	buffG.setColor(Color.LIGHT_GRAY);
         buffG.fillRect(0, 0, dim.width, dim.height);
    	*/
		
		g.drawImage(dirt, 0, 0, null);
    	
         //TODO optimize this
    	/*
    	for(int x = 0; x < dim.width; x += dirt.getWidth()){
    		for(int y = 0; y < dim.height; y += dirt.getHeight() ){
    			g.drawImage(dirt, x, y, null);
    		}
    	}
    	*/
        
    }
    
    /**
     * Draws the Apple
     */
    private void drawApple(Graphics g) {
        g.drawImage(apple, (int)(game.getApple().getLocation().getX()*blockSize)+blockSize, (int)(game.getApple().getLocation().getY()*blockSize)+blockSize, blockSize,blockSize, null);
    }
    
    /**
     *  
     * Draws the Board
     */
    private void drawBoard(Graphics g){
    	g.setColor(Color.WHITE);
    	
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
