package Patterns.SlidingWindow;

public class MaximumSumSubArray_01 {
    public static void main(String[] args) {
        int[] arr = {2,1,5,1,3,2};
        int k = 3;
        //expected op : 9   -> [5,1,3] window
        System.out.println(maxSumSubArray(arr,k));
    }
    public static int maxSumSubArray(int[] arr,int k){
        if(arr.length==0) return -1;
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int i=0;
        int j = 0;
        while(j<arr.length){
            windowSum+=arr[j];
            if(j-i+1 == k){
                maxSum= Math.max(maxSum,windowSum);
                windowSum -= arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }
}

//output : 9 correct
