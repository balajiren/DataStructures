package Deque;
import java.util.*;

public class SnakeGame {

	
	   int r;
	    int c;
	    int rows;
	    int cols;
	    int index;
	    int score;
	    int[][] foods;
	    Queue<int[]> snake;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int move(String direction) {
        switch(direction){
            case "U":
                r--;
                break;
            case "D":
                r++;
                break;
            case "L":
                c--;
                break;
            case "R":
                c++;
                break;
        }
        if (!isValid(r,c))
            return -1;
        return process(r,c);
    }
    
    private boolean isValid(int x, int y){
        return (0<=x && x<rows && 0<=y && y<cols);
    }
	
	
	
	public int process(int r, int c) {
		
		if(index == foods.length) {
			snake.poll();
		}
		else if(r == foods[index][0] && c == foods[index][1]) {
			index++;
			score++;
		} else {
			snake.poll();
		}
		for(int[] s:snake){
			if(r == s[0] &&  c ==s[1]){
				return -1;
			}
		}
		snake.add(new int[]{r,c});
		return score;
		
		
	}

}
