package dynammic_programming;

import java.util.Arrays;

/*
Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
 */
public class KnapSack01 {
    static int[][] dp;

    KnapSack01(int n, int w) {
        dp = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    static int knapsack(int W, int val[], int wt[]) {
        // W = capacity of knapsack
        // wt[] = weight array
        // val[] = profit array

        int[][] t = new int[wt.length+1][W+1];

        for(int i=0;i<wt.length+1;i++){
            for(int j=0;j<W+1;j++){

                if(i==0 || j==0){
                    t[i][j] = 0;
                }else{

                    if(wt[i-1] <= j){
                        t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]],
                                t[i-1][j]
                        );
                    }else{
                        t[i][j] = t[i-1][j];
                    }
                }
            }
        }
        return t[wt.length][W];

    }

    static int usingMemoization(int[] wt,int[] val,int w,int n){
        if(n==0 || w==0){
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }
        if(wt[n-1] <= w){
            dp[n][w] = Math.max(val[n-1]+usingMemoization(wt,val,w-wt[n-1],n-1),
                    usingMemoization(wt,val,w,n-1));
        }else {
            dp[n][w] = usingMemoization(wt,val,w,n-1);
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
       int  W = 4;
       int[] val = new int[]{1, 2, 3};
       int[] wt = new int[]{4, 5, 1};
        KnapSack01 obj = new KnapSack01(wt.length,W);
        System.out.println("using Top Down approach :> "+ knapsack(W,val,wt)); // top down approach
        System.out.println("Using Memoization :> "+usingMemoization(wt,val,W,wt.length)); // using memoization approach
    }
}
