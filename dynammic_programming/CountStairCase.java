package dynammic_programming;

public class CountStairCase {
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        System.out.println(count(n,dp));
    }
    static int count(int n,int[] dp){
        if(n<3){
            dp[n] = n;
            return dp[n];
        }
        dp[n] = count(n-1,dp)+count(n-2,dp);
        return dp[n];
    }
}
