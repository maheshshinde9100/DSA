// 260. Single Number III
// Solved
// Medium
// Topics
// Companies
// Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
// You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
class Solution {
    public int[] singleNumber(int[] nums) {
      Arrays.sort(nums); 
        int i = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (i < nums.length) {
     if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                arr.add(nums[i]);
                i++;
            } else {
                i += 2;
            }
        }
        int[] res = new int[arr.size()];
        for (int j = 0; j < arr.size(); j++) {
            res[j] = arr.get(j);
        }

        return res;
    }
}
