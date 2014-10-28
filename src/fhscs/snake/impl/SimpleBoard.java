package fhscs.snake.impl;

import java.awt.Dimension;
import java.awt.Point;

import fhscs.snake.Board;

public class SimpleBoard implements Board {

    private final Dimension dimensions;
    
    public SimpleBoard(Dimension dimensions) {
        this.dimensions = dimensions;
    }
    
    public SimpleBoard(int width, int height) {
        this(new Dimension(width, height));
    }
    
    public SimpleBoard() {
        this(50, 50);
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
    
}
