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

    private int score = 0;

    private volatile boolean running = true;
    
    // Game Controllers
    
    private final GameGraphics graphics;
    
    private final GameLogic logic;
    
    private final Timer gameTimer;
    
    private final SnakeTask task;
    
    // Implementation
    
    public SimpleGame() {
        this(new SimpleBoard());
    }
    
    public SimpleGame(Board board) {
        this.board = board;
        this.snake = new SimpleSnake(new Point(board.getWidth()/2, board.getHeight()/2));
        this.apple = new SimpleApple(board,4,6);
        
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
                gameTimer.schedule(task, 0, 100);
            } else {
                // The game is stopping
                System.out.println("Snake Game Stopping!");
                graphics.closeWin();
            }
            System.out.println("runinng: " + running);
          
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
    public void decrementScore() {
        this.score--;
    }

    @Override
    public void incrementScore(int amount) {
        this.score += amount;
    }

    @Override
    public void decrementScore(int amount) {
        this.score -= amount;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }
		
    
}
