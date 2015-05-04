package fhscs.snake.impl;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import fhscs.snake.Game;

public class GameGraphics {
    
    private final JFrame frame;
    
    private final SnakeKeyListener keyListener;
    
    private final GameCanvas canvas;
    
    public GameGraphics(Game game) {
        this.frame = new JFrame();
        this.canvas = new GameCanvas(game);
        frame.setSize(new Dimension(((game.getBoard().getWidth() + 4)*GameCanvas.blockSize),((game.getBoard().getHeight() + 6)*GameCanvas.blockSize)));
        //frame.setResizable(false);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        frame.add(canvas);
        this.keyListener = new SnakeKeyListener(game);
        canvas.addKeyListener(keyListener);
        canvas.setFocusable(true);
        canvas.setVisible(true);
        canvas.paint(canvas.getGraphics());
        
    }
    
    public GameCanvas getCanvas(){
		return canvas;	
    }
    
    /**
     * Updates the graphics
     */
    public void update() {
        canvas.invalidate();
        canvas.validate();
        canvas.repaint();
        
    }
   
    public void closeWin(){
    	frame.setVisible(false); 
    	frame.dispose();
    }
}
