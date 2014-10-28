package fhscs.snake.impl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import fhscs.snake.Direction;
import fhscs.snake.Snake;

public class SimpleSnake implements Snake {

    private final List<Point> points;
    
    private Direction direction;
    
    public SimpleSnake() {
        this.points = new ArrayList<>();
        this.direction = Direction.EAST;
    }

    @Override
    public List<Point> getLocations() {
        return points;
    }

    @Override
    public void move() {
        points.remove(0);
        Point next = new Point();
        switch(direction) {
            case NORTH:
                next.y++;
                break;
            case SOUTH:
                next.y--;
                break;
            case EAST:
                next.x++;
                break;
            case WEST:
                next.x--;
                break;
        }
        points.add(next);
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Point getHead() {
        return points.get(points.size() - 1);
    }
    
}
