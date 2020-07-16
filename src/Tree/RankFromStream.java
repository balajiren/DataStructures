package Tree;

public class RankFromStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class RankNode
	{
		RankNode left;
		RankNode right;
		int data;
		int left_size;
		RankNode(int d)
		{
			data = d;
		}
		
		public void Insert(int d)
		{
			if(d <= data)
			{
				if(left != null)
				{
					left.Insert(d);
					
				} else
				{
					left = new RankNode(d);
				}
				left_size++;
			}
			else
			{
				if(right != null)
				{
					right.Insert(d);
				} else
				{
					right = new RankNode(d);
				}
			}
			
		}
		
		
		public int getRank(int d)
		{
			if(d == data)
			{
				return left_size;
			}
			
			if(d <= data)
			{
				if(left == null)
				{
					return -1;
				}
				return left.getRank(d);
			} else
			{
				int right_rank = right !=null ? right.getRank(d) : -1;
				if(right_rank ==  -1)  {
					return -1;
				}
				return 1+left_size+right_rank;
				
			}


	
			
		}
	
	}
	

}
