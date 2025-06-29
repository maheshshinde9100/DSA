package Patterns.CyclicSort;
import java.util.*;
class FirstMissingPossitive {
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        System.out.println(firstMissingPositive(arr));
    }
    static int firstMissingPositive(int[] arr) {
        int i = 0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(correct>=0 && correct<arr.length && arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int index = 0;index<arr.length;index++){
            if(arr[index]!=index && arr[index]>0){
                System.out.println(index);
            }
        }
        return i;
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}