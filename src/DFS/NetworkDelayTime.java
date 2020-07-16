package DFS;

import java.util.*;

public class NetworkDelayTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 Map<Integer, Integer> dist;
	    public int networkDelayTime_DFS(int[][] times, int N, int K) {
	        Map<Integer, List<int[]>> graph = new HashMap();
	        for (int[] edge: times) {
	            if (!graph.containsKey(edge[0]))
	                graph.put(edge[0], new ArrayList<int[]>());
	            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
	        }
	        for (int node: graph.keySet()) {
	            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
	        }
	        dist = new HashMap();
	        for (int node = 1; node <= N; ++node)
	            dist.put(node, Integer.MAX_VALUE);

	        dfs(graph, K, 0);
	        int ans = 0;
	        for (int cand: dist.values()) {
	            if (cand == Integer.MAX_VALUE) return -1;
	            ans = Math.max(ans, cand);
	        }
	        return ans;
	    }

	    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
	        if (elapsed >= dist.get(node)) return;
	        dist.put(node, elapsed);
	        if (graph.containsKey(node))
	            for (int[] info: graph.get(node))
	                dfs(graph, info[1], elapsed + info[0]);
	    }
	
	public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }

}
