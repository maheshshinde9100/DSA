import java.util.*;
class TwoSum {
    boolean twoSum(int arr[], int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                if(complement+arr[i] == target){
                    System.out.println("INDEXS :> "+map.get(complement)+" & "+i);
                    System.out.println("Values :> "+complement+" + "+arr[i]+" = "+target);
                    return true;
                }
            }
            map.put(arr[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,8,3,5,9,7};
        TwoSum obj = new TwoSum();
        System.out.println(Arrays.toString(arr));
        System.out.println("Target => 16");
        System.out.println(obj.twoSum(arr, 16));
    }
}