package Matrix;

public class PrintAllMatrixPathsWithObstruction
{
    
    
public static void main(String args[])
{

    int arrA [][] = {{1,1,1},{1,1,1},{1,-1,1}};
    long start = System.currentTimeMillis();
    int numofPaths =  CountNumberOfPaths(arrA);

    System.out.println(numofPaths);
    
}


private static int CountNumberOfPaths(int[][] input)
{
    int[][] dp = new int[input.length][input.length];
    
    for(int i=0;i<input.length;i++)
    {
        
        dp[0][i] = 1;
    }
     for(int i=0;i<input.length;i++)
    {
        
        dp[i][0] = 1;
    }
    
   for(int i=1;i<input.length;i++)
   {
       
        for(int j=1;j<input.length;j++)
        {
            if(dp[i][j]!=-1){
            
                dp[i][j]=0;
                if( dp[i-1][j] > 0)
                {
                dp[i][j] = dp[i-1][j]; 
                }
                 if(  dp[i][j-1] > 0)
                {
                dp[i][j] =  dp[i][j-1];
                }
            }
            
        }
       
       
       
   }
    
    return dp[input.length-1][input.length-1];
    
    
    
}
    
    
    
    
    
    
}
