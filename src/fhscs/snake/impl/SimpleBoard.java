package fhscs.snake.impl;

import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import fhscs.snake.Board;

public class SimpleBoard implements Board {

    private final Dimension dimensions;
    private int score;
    private int highScore;
    
    public SimpleBoard(Dimension dimensions) {
        this.dimensions = dimensions;
        highScore = readScoreLog();
    }
    
    public SimpleBoard(int width, int height) {
        this(new Dimension(width, height));
    }
    
    public SimpleBoard() {
        this(30, 20);
    }
    
    public int getWidth() {
        return dimensions.width;
    }
    
    public int getHeight() {
        return dimensions.height;
    }
    
    public boolean isOutside(Point point) {
        return point.x > dimensions.width || point.y > dimensions.height || point.x < 0 || point.y < 0;
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
    public void incrementScore(int amount) {
        this.score += amount;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

	@Override
	public void logScore(int score) {
		//TODO this
		PrintWriter outt;
		try {
			outt = new PrintWriter(new FileWriter(System.getProperty("user.dir") + "\\attributes\\Log\\ScoreLog.sn"));
			outt.println(score);
			outt.close();
		} catch (IOException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int readScoreLog() {
		
		BufferedReader log;
		String score = null;
		try {
			log = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\attributes\\log\\ScoreLog.sn"));
			score = log.readLine();
			log.close();
		} catch (IOException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}	
		return Integer.parseInt(score);
	}

	@Override
	public int getHighScore() {
		return highScore;
	}

	@Override
	public void setHighScore(int score) {
		highScore = score;
		
	}
    
}
