package dynammic_programming;

import java.util.Arrays;

/* Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
*/
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(rob(n-1,nums,dp));
    }
    public static int rob(int n, int[] nums,int[] dp) {
        if(n<0) return 0;
        if(n==0) return nums[0];

        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = Math.max(rob(n-1,nums,dp),nums[n]+rob(n-2,nums,dp));
        return dp[n];
    }
}
