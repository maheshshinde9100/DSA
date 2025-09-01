/*
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.
To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from any step either one or two steps, provided it exists. Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
*/
import java.util.*;
class FrogJump {
    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, heights, dp);
    }

    private int solve(int i, int[] heights, int[] dp) {
        if (i == 0) return 0; 
        if (dp[i] != -1) return dp[i];

        int oneStep = solve(i - 1, heights, dp) + Math.abs(heights[i] - heights[i - 1]);
        int twoStep = Integer.MAX_VALUE;
        if (i > 1) {
            twoStep = solve(i - 2, heights, dp) + Math.abs(heights[i] - heights[i - 2]);
        }

        return dp[i] = Math.min(oneStep, twoStep);
    }
}
