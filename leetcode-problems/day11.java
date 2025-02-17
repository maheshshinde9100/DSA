// two sum LeetCode
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n =nums.length;
        int[] arr = new int[]{};     
        for(int i=0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(nums[i]+nums[j]==target){
                    arr = new int[]{i,j};
                }
            }
        }
        return arr;
    }
}