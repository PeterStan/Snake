package fhscs.snake.impl;

import java.util.TimerTask;

/**
 * @author 0100977
 *
 */
public class SnakeTask extends TimerTask {

	private final SimpleGame game;
	
	public SnakeTask(SimpleGame game) {
		this.game = game;
	}

	@Override
	public void run() {
        while(game.isRunning()) {
            game.getLogicController().run();
            game.getGraphicsController().update();
        }
        game.getGraphicsController().closeWin();
	}

}
