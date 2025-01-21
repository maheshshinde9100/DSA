/* 55. Jump Game Medium
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise */
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(i > max){
                return false;
            }
            max = Math.max(max,i+nums[i]);
            if(max>=n-1){
                return true;
            }
        }
        return max >= n - 1;
    }
}
