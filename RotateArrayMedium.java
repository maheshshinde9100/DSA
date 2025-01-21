// 189. Rotate Array - medium
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
class Solution {
    public void rotate(int[] nums, int k) {
      int n = nums.length;
        int[] result = new int[n];
        k = k % n; 
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, n);  
    }
}
