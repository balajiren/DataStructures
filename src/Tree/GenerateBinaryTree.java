package Tree;
import java.util.*;

public class GenerateBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<TreeNode> generateTree(int n) {
		
		return Generate(1,n);
		
	}
	public static List<TreeNode> Generate(int m, int n) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		
		for(int i=m;i<=n;i++) {
			
			List<TreeNode> ls = Generate(m,i-1);
			List<TreeNode> rs = Generate(i+1,n);
			for(TreeNode l : ls) {
				
				for(TreeNode r : rs) {
					TreeNode current = new TreeNode(i);
					current.left = l;
					current.right = r;
					result.add(current);
					
				}
			}
	
		}
		
		return result;
	}

}
