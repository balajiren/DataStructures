package Matrix;

import java.util.*;

public class ShortestPathToDestination {

	//output shortest path length between two points in a matrix
	   private static int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


	   private static int shortestPath3(int[][] matrix, int x1, int y1, int x2, int y2) {
	       if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
	           return -1;
	       }
	       int m = matrix.length;
	       int n = matrix[0].length;
	       if (!isValid(matrix, m, n, x1, y1) || !isValid(matrix, m, n, x2, y2)) {
	           return -1;
	       }
	       Queue<Integer> queue = new LinkedList<>();
	       boolean[][] visited = new boolean[m][n];
	       int res = 0;

	       queue.offer(x1 * n + y1);
	       visited[x1][y1] = true;//if we can modify the board, use matrix[x1][y1] = 1;
	       while (!queue.isEmpty()) {
	           int size = queue.size();
	           for (int i = 0; i < size; i++) {
	               int key = queue.poll();
	               int x = key / n;
	               int y = key % n;
	               if (x == x2 && y == y2) {
	                   return res;
	               }
	               for (int k = 0; k < move.length; k++) {
	                   int nextX = x + move[k][0];
	                   int nextY = y + move[k][1];
	                   if (isValid(matrix, m, n, nextX, nextY) && !visited[nextX][nextY]) {//matrix[nextX][nextY] != 1
	                       queue.offer(nextX * n + nextY);
	                       visited[nextX][nextY] = true;//matrix[nextX][nextY] = 1
	                   }
	               }
	           }
	           res++;
	       }
	       return -1;
	   }

	   private static boolean isValid(int[][] matrix, int m, int n, int i, int j) {
	       if (i < 0 || i >= m || j < 0 || j >= n) {
	           return false;
	       }
	       return true;
	   }

	public static int shortestPath(int[][] grid, int k) {

		//if grid is null or length with 0 return -1
		if (grid == null || grid.length == 0) return -1;

		//row length
		int n = grid.length;

		//col length
		int m = grid[0].length;

		//direction right, down, left and up
		int[] dirs = new int[]{0, 1, 0, -1, 0};

		int[][] seen = new int[n][m];

		//fill with max value
		for (int i = 0; i < n; i++) {
			Arrays.fill(seen[i], Integer.MAX_VALUE);
		}

		/// queue to track points and obstacles used
		Queue<int[]> q = new LinkedList<>();

		int steps = 0;

		seen[0][0] = 0;

		//insert initial value
		q.add(new int[]{0, 0, 0});

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] data = q.poll();

				if (data[0] == n - 1 && data[1] == m - 1)
					return steps;

				for (int j = 0; j < 4; j++) {

					int x = data[0] + dirs[j];
					int y = data[1] + dirs[j + 1];

					if (x >= 0 && x < n && y >= 0 && y < m) {

						int obstacles = data[2] + grid[x][y];

						if(obstacles>k || obstacles>=seen[x][y])
							continue;

						//else add in queue
						seen[x][y] = obstacles;
						q.add(new int[]{x,y,obstacles});
					}

				}

			}
			steps++;
		}
		// if no path found
		return -1;

	}
}
