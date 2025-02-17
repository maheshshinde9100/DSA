// Arsh
import java.util.*;

class Solution1 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new ArrayList<>();
        int count=0;
        // for(int n: nums){
        //     count++;
        //     for(int i=count;i<nums.length;i++){
        //         if(n==nums[i]){
        //             dups.add(n);
        //         }
        //     }
        // }
        // return dups;
            for(int i=0;i<nums.length;i++){
                 int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dups.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return dups;
    }
}

//Apna clg
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
                        if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }
        return minHeap.peek();
    }
}