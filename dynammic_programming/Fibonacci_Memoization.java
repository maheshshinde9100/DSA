package dynammic_programming;

import java.util.Arrays;

public class Fibonacci_Memoization {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibonacci(n,dp));

    }
    static int fibonacci(int n,int[] dp){
        if(n<2){
            dp[n] = n;
            return dp[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = fibonacci(n-1,dp)+fibonacci(n-2,dp);
        return dp[n];
    }
}
