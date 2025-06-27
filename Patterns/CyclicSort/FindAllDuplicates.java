package Patterns.CyclicSort;
import java.util.*;
public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {4,3,2,7,8,2,3,1};
        int[] nums2 = {1,1,2};

        System.out.println(Arrays.toString(nums1));
        System.out.println(findDuplicates(nums2).toString());
    }
   static List<Integer> findDuplicates(int[] nums) {
       List<Integer> list = new ArrayList<>();
       int i = 0;
       while(i<nums.length){
           int correct = nums[i]-1;
           if(correct<nums.length && nums[i]!=nums[correct]){
               int temp = nums[i];
               nums[i] = nums[correct];
               nums[correct] = temp;
           }else{
               i++;
           }
       }

       for (int j = 0; j < nums.length; j++) {
           if (nums[j] != j + 1) {
               list.add(nums[j]);
           }
       }
       return list;
   }
}