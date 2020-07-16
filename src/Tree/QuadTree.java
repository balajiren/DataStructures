package Tree;

class QuadNode {
    public boolean val;
    public boolean isLeaf;
    public QuadNode topLeft;
    public QuadNode topRight;
    public QuadNode bottomLeft;
    public QuadNode bottomRight;

    
    public QuadNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public QuadNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public QuadNode(boolean val, boolean isLeaf, QuadNode topLeft, QuadNode topRight, QuadNode bottomLeft, QuadNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

public class QuadTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public QuadNode construct(int[][] grid) {
	        return construct(grid, 0, 0, grid.length);
	    }
	    
	    public QuadNode construct(int[][] grid, int x, int y, int size) {
	        if(size == 0) {
	            return null;
	        }
	        QuadNode QuadNode = new QuadNode();
	        if(gridHasSameValues(grid, x, y, size) != -1) {
	            QuadNode.val = gridHasSameValues(grid, x, y, size) == 0 ? false : true;
	            QuadNode.isLeaf = true;
	            return QuadNode;
	        }
	        QuadNode.topLeft = construct(grid, x, y, size/2);
	        QuadNode.topRight = construct(grid, x, y+size/2, size/2);
	        QuadNode.bottomLeft = construct(grid, x+size/2, y, size/2);
	        QuadNode.bottomRight = construct(grid, x+size/2, y+size/2, size/2);
	        return QuadNode;
	    }
	    
	    public int gridHasSameValues(int[][] grid, int x, int y, int size) {
	        int value = grid[x][y];
	        for(int i = x; i<x+size; i++) {
	            for(int j = y; j < y+size; j++) {
	                if(grid[i][j] != value) {
	                    value = -1;
	                    break;
	                }
	            }
	        }
	        return value;
	    }

}
