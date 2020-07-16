package Matrix;
import java.util.*;

//https://leetcode.com/problems/candy-crush/solution/
//https://leetcode.com/problems/candy-crush/discuss/164698/getCandiesToCrush-%2B-eliminateCandies-%2B-dropCandies
//Three steps:

//		getCandiesToCrush() helps build List<int[]> candyToCrush which saves coordinates of candies to crush in the current round.
//		we elimate candies to crush together using eliminateCandies().
//		we restore the board to a stable state by dropCandies().
//		We follow the pattern described above round by round until candyToCrush is empty.
//
//		Within dropCandies, we drop candies column by column with two pointers top, bottom .
//		They start at board.length - 1 initially.
//		top keeps going up until find a candy to drop, and then we drop the candy to bottom and increase bottom, top keeps going up ...
public class CandyCrush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private List<int[]> candyToCrush;

	public int[][] candyCrush(int[][] board) {
		candyToCrush = new LinkedList<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					getCandiesToCrush(i, j, board, board[i][j]);
				}
			}
		}

		if (candyToCrush.isEmpty()) {
			return board;
		}

		eliminateCandies(board);
		dropCandies(board);

		return candyCrush(board);
	}

	private void getCandiesToCrush(int x, int y, int[][] board, int val) {
		if (x + 2 < board.length && val == board[x + 1][y] && val == board[x + 2][y]) {
			candyToCrush.add(new int[]{x, y});
			candyToCrush.add(new int[]{x + 1, y});
			candyToCrush.add(new int[]{x + 2, y});
		}
		if (y + 2 < board[0].length && val == board[x][y + 1] && val == board[x][y + 2]) {
			candyToCrush.add(new int[]{x, y});
			candyToCrush.add(new int[]{x, y + 1});
			candyToCrush.add(new int[]{x, y + 2});
		}
	}

	private void eliminateCandies(int[][] board) {
		for (int[] coordinate : candyToCrush) {
			board[coordinate[0]][coordinate[1]] = 0;
		}
	}

	private void dropCandies(int[][] board) {
		for (int j = 0; j < board[0].length; j++) {
			int top = board.length - 1, bottom = board.length - 1;
			while (top >= 0) {
				if (board[top][j] != 0) {
					board[bottom][j] = board[top][j];
					bottom--;
				}
				top--;
			}
			while (bottom >= 0) {
				board[bottom][j] = 0;
				bottom--;
			}
		}
	}
}
