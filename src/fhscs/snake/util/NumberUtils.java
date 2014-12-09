package fhscs.snake.util;

import java.util.Random;

public class NumberUtils {

    public static int randomInt(int a, int b) {
        if(a==b) return a;
        int l = a < b ? a : b;
        int h = a < b ? b : a;
        
        return l + new Random().nextInt(h - l);
    }
    
    public static double randomDouble(double a, double b) {
        if(a==b) return a;
        
        double c = Math.random() * Math.abs(a-b);
        return a < b
             ? a + c
             : a - c;
    }
    
}
