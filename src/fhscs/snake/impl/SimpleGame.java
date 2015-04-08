package fhscs.snake.impl;

import java.awt.Point;
import java.util.Timer;

import fhscs.snake.Board;
import fhscs.snake.Game;
import fhscs.snake.Snake;

public class SimpleGame implements Game {

    // Game Attributes
    
    private final Board board;
    
    private final Snake snake;
    
    private SimpleApple apple;

    private volatile boolean running = true;
    
    // Game Controllers
    
    private final GameGraphics graphics;
    
    private final GameLogic logic;
    
    private Timer gameTimer;
    
    private final int runSpeed = 100;
    
    private SnakeTask task;
    
    private boolean paused = false;
    
    // Implementation
    
    public SimpleGame() {
        this(new SimpleBoard());
    }
    
    public SimpleGame(Board board) {
        this.board = board;
        this.snake = new SimpleSnake(new Point(board.getWidth()/2, board.getHeight()/2));
        this.apple = new SimpleApple(board);
        
        this.logic = new GameLogic(this);
        
        this.gameTimer = new Timer();
        this.task = new SnakeTask(this);
        
        this.graphics = new GameGraphics(this);
    }
    
    public GameGraphics getGraphicsController() {
        return graphics;
    }
    
    public GameLogic getLogicController() {
        return logic;
    }
    
    public Snake getSnake() {
        return snake;
    }
    
    public SimpleApple getApple() {
        return apple;
    }
    
    public Board getBoard() {
        return board;
    }
    
    public boolean isRunning() {
        return running;
    }
    
    public void setRunning(boolean running) {
       if(this.running != running) {
            this.running = running;
       }
            if(running) {
                // Now the game is running
                System.out.println("Snake Game Starting!");
                gameTimer.schedule(task, 0, runSpeed);
            } else {
                // The game is stopping
                System.out.println("Snake Game Stopping!");
                graphics.closeWin();
            }
            System.out.println("runinng: " + running);
          
    }	
    
    public void pauseGame(){
    	this.gameTimer.cancel();
    	this.task.cancel();
    	setPaused(true);
    }
    
    public void resumeGame(){
    	this.gameTimer = new Timer();
    	this.task = new SnakeTask(this);
    	this.gameTimer.schedule(task, 0, runSpeed);
    	setPaused(false);
    }

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
    
}
