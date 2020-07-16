package DynamicProgramming;
import java.util.*;
//dp[i][v] =Math.max( dp[i-1][v], dp[i-1][v-kP[i]] + kS[i])

//        P1=15, S1=45, A1=3 (AAPL)
//        P2=40, S2=50, A2=3 (BYND)
//        P3=25, S3=35, A3=3 (SNAP)
//        P4=30, S4=25, A4=4 (TSLA)

class ItemValue
{
    Double cost;
    double S, P, A;
    // item value function
    public ItemValue(int S, int P, int A)
    {
        this.S = S;
        this.P = P;
        this.A = A;
        cost = new Double(S/P);
    }
}
public class StockValueOptimization {

    public static void main(String[] args) {
        int M = 140;
        int[] S = new int[] {45,50,35,25};
        int[] P = new int[] {15,40,25,30};
        int[] A = new int[] {3,3,3,4};
        int[][] memo = new int[S.length+1][M+1];

        for (int i = 0; i < S.length; i++)
            for (int j = 0; j < M + 1; j++)
                memo[i][j] = -1;

        System.out.println(MaxRevenue(S.length-1, M, memo, S, P, A));
        System.out.println(MaxRevenue_Fractional(M,S, P, A));
    }

    public static int MaxRevenue(int i, int m, int[][] memo, int[] S, int[] P, int[]A) {
        if(i == -1) {
            return 0;
        }
        if(memo[i][m] > -1){
            return memo[i][m];
        }
        int max = 0;
        int range = A[i]+1;
        for(int a=0;a<range;a++) {

            if(m - a*P[i] >= 0) {
                int temp = MaxRevenue(i - 1, m - a*P[i], memo, S, P, A);
                memo[i][m] = Math.max(MaxRevenue(i - 1, m, memo, S, P, A),temp + a*S[i]);
            } else {
                memo[i][m] = MaxRevenue(i - 1, m, memo, S, P, A);
            }

        }
        return memo[i][m];
    }

    public static int MaxRevenue_Fractional(int M, int[] S, int[] P, int[]A) {

        ItemValue[] iVal = new ItemValue[A.length];

        for(int i = 0; i < A.length; i++) {
            ItemValue val  = new ItemValue(S[i],P[i],A[i]);
            iVal[i] = val;

        }

        Arrays.sort(iVal, new Comparator<ItemValue>()
        {
            @Override
            public int compare(ItemValue o1, ItemValue o2)
            {

                return o1.cost.compareTo(o2.cost);
            }
        });

        Double[] A1 = new Double[A.length];
        for(int i=0;i<iVal.length;i++) {
            P[i] = (int) iVal[i].P;
            A[i] = (int) iVal[i].A;
            S[i] = (int) iVal[i].S;
            A1[i] = iVal[i].cost;

        }
        System.out.println(Arrays.toString(A1));
        int revenue=0, i = iVal.length-1;
        while (M > 0 && i >=0) {
            int num_shares = Math.min(M/P[i],A[i]);
            revenue += num_shares*S[i];
            M -= num_shares*P[i];
            i -= 1;

        }
     return revenue;
    }


}
