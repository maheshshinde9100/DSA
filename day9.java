class Solution {
    public int search(int[] nums, int target) {
        int count=-1;
        for(int x: nums){
            count++;
            if(x==target){
                return count;
            }
        }
        return -1;
    }
}
