package Heap;
import java.util.*;

public class KthSmallestInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int kthSmallest(int[][] mx, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> mx[a[0]][a[1]] - mx[b[0]][b[1]]);
        for (int i = 0; i < mx.length; i++) {
            pq.offer(new int[] {i, 0});
        }
        while (k > 0) {
            int[] curr = pq.poll();
            k--;
            if (k == 0) return mx[curr[0]][curr[1]];
            if (curr[1] + 1 < mx[0].length) pq.offer(new int[] {curr[0], curr[1] + 1});
        }
        return -1;
    }

}
