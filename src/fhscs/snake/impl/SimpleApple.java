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
	}

	@Override
	public Point getLocation() {
		return a;
	}

	@Override
	public void eatApple(Snake snake) {
		if(snake.getHead().equals(a)){
			snake.elongate();
			board.incrementScore();
			newApple();
		}
	}

	@Override
	public void newApple() {
		a = new Point(NumberUtils.randomInt(0, board.getWidth()), NumberUtils.randomInt(0, board.getHeight()));

	}

}
