package fhscs.snake.impl;

import java.awt.Dimension;
import java.awt.Point;

import fhscs.snake.Board;

public class SimpleBoard implements Board {

    private final Dimension dimensions;
    private int score;
    
    public SimpleBoard(Dimension dimensions) {
        this.dimensions = dimensions;
    }
    
    public SimpleBoard(int width, int height) {
        this(new Dimension(width, height));
    }
    
    public SimpleBoard() {
        this(30, 20);
    }
    
    public int getWidth() {
        return dimensions.width;
    }
    
    public int getHeight() {
        return dimensions.height;
    }
    
    public boolean isOutside(Point point) {
        return point.x > dimensions.width || point.y > dimensions.height || point.x < 0 || point.y < 0;
    }
    
    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void incrementScore() {
        this.score++;
    }

    @Override
    public void incrementScore(int amount) {
        this.score += amount;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }
    
}
