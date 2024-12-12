// 268.mising number in array - leetcode
class Solution {
    public int missingNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i:nums){ 
            if(i==count){
                count++;
                continue;
            }else{
                return count;
            }
        }
        return count;
    }
}