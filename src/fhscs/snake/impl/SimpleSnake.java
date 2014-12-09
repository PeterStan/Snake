package fhscs.snake.impl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import fhscs.snake.Movement;
import fhscs.snake.Snake;

public class SimpleSnake implements Snake {

    private final List<Point> points;
    
    private Movement movement;
    
    public SimpleSnake(Point head) {
        this.points = new ArrayList<>();
        this.points.add(head);
        this.movement = Movement.EAST;
    }
    
    @Override
    public int getSize() {
        return points.size();
    }

    @Override
    public List<Point> getLocations() {
        return points;
    }

    @Override
    public void move() {
        if(movement == Movement.NOT_MOVING)
            return;
        
        points.remove(0);
        Point next = new Point();
        switch(movement) {
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
            default:
                break;
        }
        points.add(next);
    }

    @Override
    public Movement getMovement() {
        return movement;
    }

    @Override
    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    @Override
    public Point getHead() {
        return points.get(points.size() - 1);
    }

    @Override
    public void elongate() {
        elongate(1);
    }

    @Override
    public void shorten() {
        shorten(1);
    }

    @Override
    public void elongate(int amount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void shorten(int amount) {
        // TODO Auto-generated method stub
        
    }
    
}