package fhscs.snake.impl;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import fhscs.snake.Game;

public class GameGraphics {
    
    private final JFrame frame;
    
    public GameGraphics(Game game) {
        this.frame = new JFrame();
        frame.setSize(new Dimension(700, 700));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new GameCanvas(game));
    }
    
    /**
     * Updates the graphics
     */
    public void update() {
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    
}
