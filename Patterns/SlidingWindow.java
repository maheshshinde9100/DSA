package Patterns;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1,2,6,2,2,5};
        int k = 3;
        System.out.println(maximumSubarraySum(arr,k));
    }
    public static int maximumSubarraySum(int[] arr, int k){
        int i =0;
        int j = 0;
        int currSum = 0;
        int maxSum = 0;
        while(j< arr.length){
            currSum+=arr[j];
            if(j-i+1==k){
                maxSum = Math.max(currSum,maxSum);
                currSum -= arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
