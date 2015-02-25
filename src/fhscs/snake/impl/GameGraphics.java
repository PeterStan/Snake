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
        frame.setSize(new Dimension(2 * GameCanvas.blockSize * game.getBoard().getWidth(), 2 * GameCanvas.blockSize * game.getBoard().getHeight()));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.canvas = new GameCanvas(game);
        frame.add(canvas);
        this.keyListener = new SnakeKeyListener(game);
        canvas.addKeyListener(keyListener);
    }
    
    /**
     * Updates the graphics
     */
    public void update() {
        canvas.invalidate();
        canvas.validate();
        canvas.repaint();
    }
    
}
