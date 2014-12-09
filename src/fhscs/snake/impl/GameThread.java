package fhscs.snake.impl;

public class GameThread extends Thread {
    
    private final SimpleGame game;
    
    private static long speed = 1000L;
    
    public GameThread(SimpleGame game) {
        this.game = game;
    }
    
    @Override
    public void run() {
        while(game.isRunning()) {
            game.getLogicController().run();
            game.getGraphicsController().update();
            
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
