package Patterns.CyclicSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,3,1,2,4};
        System.out.println(Arrays.toString(arr));
        sortArr(arr);
        System.out.println("After Cyclic sort :> "+ Arrays.toString(arr));

        int[] arr1 = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr1));
    }
    static void sortArr(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct_index = arr[i]-1;
            if(arr[i] != arr[correct_index]){
                swap(arr,i,correct_index);
            }else{
                i++;
            }
        }
    }
    static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // LeetCode Missing Number

        static int missingNumber(int[] nums) {
            int i = 0;

            while(i<nums.length-1){
                int correct = nums[i]-1;
                if(nums[i] != nums[correct]){
                    swap(nums,i,correct);
                }else{
                    i++;
                }
            }
            return findMissing(nums);
        }

        static int findMissing(int[] arr){
            for(int i=0;i<arr.length;i++){
                if(arr[i]!=i){
                    return i;
                }
            }
            return -1;
        }
}
