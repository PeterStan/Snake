package fhscs.snake.impl;

import java.awt.Point;

import fhscs.snake.Game;

public class GameThread extends Thread {
    
    private final Game game;
    
    public GameThread(Game game) {
        this.game = game;
    }
    
    @Override
    public void run() {
        while(game.isRunning()) {
            game.getSnake().move();
            Point head = game.getSnake().getHead();
            
            if(game.getBoard().isOutside(head)){
                // TODO: snake is out of bounds
                return;
            }
            
            if(head.equals(game.getApple())) {
                // TODO: snake has reached apple
            }
            
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
