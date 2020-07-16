package Tree;

public class RankOfNumber {
	
	public class RankNode
	{
		public int left_size;
		public int data;
		public RankNode left,right;
		public RankNode(int d)
		{
			data = d;
			
		}
		
		public void insert(int d)
		{
			
			if(d <= data)
			{
				
				if(left!=null)
				{
					left.insert(d);
					//left_size++;
				}
				else
				{
					left = new RankNode(d);
					left_size++;
				}
			}
			else
			{
				if(right!=null)
				{
					right.insert(d);
					//left_size++;
				}
				else
				{
					right = new RankNode(d);
					
				}
				
				
			}
			
			
		}
		
		
		public int GetRank(int d)
		{
			
			if(d == data)
			{
				return left_size;
			}
			else if(d < data)
			{
				if(left == null)
				{
					return -1;
				}
				else
				{
					left.GetRank(d);
					
				}
			}
			else {
				
				if(right == null)
				{
					return -1;
				}
				else
				{
					right.GetRank(d);
					
				}
				
			}
			
			return -1;
		}
		
		
		
		
	}
	
	public static void main(String[] args)
	{
		
		
		
		
		
	}

}

