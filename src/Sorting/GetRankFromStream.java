package Sorting;

public class GetRankFromStream {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static RankNode root = null;
	
	public static void track(int number)
	{
		
		if(root == null)
		{
			//root = new RankNode(number);
		}
		
	}
	
	
	
	public class RankNode
	{
		int data = 0;
		public RankNode left, right;
		int left_size=0;
		
		
		public RankNode(int d)
		{
			data = d;
		}
		
		public void Insert(int d)
		{
			
			if(d<=data)
			{
				if(left!=null)
				{
					left.Insert(d);
					left_size++;
				}
				else
				{
					left = new RankNode(d);
					
				}
			}
			else
			{
				if(right!=null)
				{
					right.Insert(d);
					left_size++;
				}
				else
				{
					right = new RankNode(d);
					
				}
			}
			
		}
		
		public int getRank(int d)
		{
			if(d == data) { return left_size; }
			else if(d < data)
			{
				if(left == null)
				{
					return -1;
				}
				else return left.getRank(d);
			}
			else
			{
				int right_rank = right == null ? -1 : right.getRank(d);
				if(right_rank == -1) 
				{
					return -1;
				}
				else
				{
					return left_size+1+right_rank;
				}
				
			}
			
		}
		
	}

}
