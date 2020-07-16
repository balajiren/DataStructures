package Graph;
import java.util.*;

public class TimeToInformEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
private void constructGraph(Map<Integer, List<Integer>> map, 
		int[] manager, int headID) {

		int n = manager.length;
		
		for (int i = 0; i < manager.length; i++) {
		if (manager[i] == -1) continue;
		
		map.putIfAbsent(manager[i], new ArrayList<>());
		map.get(manager[i]).add(i); // Keep manager index and employee index mapping
		}
}

public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
	Map<Integer, List<Integer>> map = new HashMap<>();
	constructGraph(map, manager, headID);
	
	return dfs(map, headID, informTime);
}

private int dfs(Map<Integer, List<Integer>> map, int manager, int[] informTime) {

	int max = 0;
	
	for (int emp : map.getOrDefault(manager, new ArrayList<>()))
	max = Math.max(max, dfs(map, emp, informTime));
	
	return max + informTime[manager];
}

}
