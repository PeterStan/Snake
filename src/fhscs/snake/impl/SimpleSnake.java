package fhscs.snake.impl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import fhscs.snake.Movement;
import fhscs.snake.Snake;

public class SimpleSnake implements Snake {

    private final List<Point> points;
    private Point nextPoint;
    
    private Movement movement;
    
    public SimpleSnake(Point head) {
        this.points = new ArrayList<>();
        this.nextPoint = head;
        this.points.add(head);
        this.points.add(new Point(head));
        this.movement = Movement.NOT_MOVING;
    }
    
    @Override
    public int getSize() {
        return points.size();
    }

    public boolean checkSnake(Point head){
    	//         added extra for neck *V*  behind snake head
    	for(int i = 0; i < points.size()-2;i++){
    		if(head.equals(points.get(i))){
    			return true;
    		}
    	}
    	
		return false;
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
        switch(movement) {
            case NORTH:
                nextPoint.y--;
                break;
            case SOUTH:
                nextPoint.y++;
                break;
            case EAST:
                nextPoint.x++;
                break;
            case WEST:
                nextPoint.x--;
                break;
            default:
                break;
        }
        
        points.add(new Point((int) nextPoint.getX(),(int)nextPoint.getY()));
        //System.out.println(points + "\n");

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
    public Point getTail() {
        return points.get(0);
    }
    
    @Override
    public Point getHead(){
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
       for(int i = 0; i < amount; i++){
    	points.add(0, getTail());
       }
    }

    @Override
    public void shorten(int amount) {
        for(int i = 0; i < amount; i++){
        	points.remove(0);
        }
        
    }
    
    public String toString() {
        return "Snake{movement='" + movement + "'}";
    }
    
}
