package fhscs.snake.impl;

import java.awt.Point;

import fhscs.snake.Apple;
import fhscs.snake.Board;
import fhscs.snake.Snake;
import fhscs.snake.util.NumberUtils;

public class SimpleApple implements Apple {
	
	Point a = new Point();
	Board board;
	
	public SimpleApple(Board board) {
		this.board = board;
		newApple();
	}
	
	public SimpleApple(Board board, int x, int y){
		this.board = board;
		a = new Point( x, y);
		
	}

	@Override
	public Point getLocation() {
		return a;
	}

	public void eatApple(Snake snake) {
		if(snake.getHead().equals(a)){
			snake.elongate();
			board.incrementScore();
			newApple(snake);
		}
	}

	@Override
	public void newApple() {
		a = new Point(NumberUtils.randomInt(0, board.getWidth()), NumberUtils.randomInt(0, board.getHeight()));
	}
	
	@Override
	public void newApple(Snake snake) {
		a = new Point(NumberUtils.randomInt(0, board.getWidth()), NumberUtils.randomInt(0, board.getHeight()));
		for(Point p: snake.getLocations()){
			if(p.equals(a))
				newApple();
		}	
	}
	
	

}
