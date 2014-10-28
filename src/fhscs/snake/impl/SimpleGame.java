package fhscs.snake.impl;

import java.awt.Point;

import fhscs.snake.Board;
import fhscs.snake.Game;
import fhscs.snake.Snake;

public class SimpleGame implements Game {

    private final Board board;
    
    private final Snake snake;
    
    private Point apple;
    
    private final GameThread gameThread;
    
    private volatile boolean running = false;
    
    public SimpleGame() {
        this.board = new SimpleBoard();
        this.snake = new SimpleSnake();
        this.gameThread = new GameThread(this);
    }
    
    public Snake getSnake() {
        return snake;
    }
    
    public Point getApple() {
        return apple;
    }
    
    public Board getBoard() {
        return board;
    }
    
    public boolean isRunning() {
        return running;
    }
    
    public void start() {
        this.running = true;
        gameThread.start();
    }
    
}
