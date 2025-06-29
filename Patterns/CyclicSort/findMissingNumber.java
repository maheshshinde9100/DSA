package Patterns.CyclicSort;

public class findMissingNumber {
    public static void main(String[] args) {
        int[] arr1 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(arr1));
}
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

static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
}