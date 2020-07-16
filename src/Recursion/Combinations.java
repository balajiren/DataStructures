package Recursion;
import java.util.*;

public class Combinations {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Combinations comb = new Combinations();
		ArrayList<ArrayList<Integer>> result = comb.combine(4,2);
		for(List<Integer> res : result) {
			System.out.println(Arrays.toString(res.toArray()));
		}


	}






	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n <= 0 || n < k)
			return result;
		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n, k, 1, item, result); // because it need to begin from 1
		return result;
	}


	private void dfs(int n, int k, int start, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> res) {
		if (item.size() == k) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = start; i <= n; i++) {
			item.add(i);
			dfs(n, k, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}

}
