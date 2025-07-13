package recursion;
public class BinarySearch{
    public static void main(String[] args){
//        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        int target = 9;
//        System.out.println("Binary Search : index > "+ binarySearch(arr,0,arr.length-1,target));
//        System.out.println("Linear Search : index > " +linearSearch(arr,0,target));

        int[] rotatedArr = new int[]{6,7,8,9,1,2,3,4,5};
        int target  = 4;
        System.out.println("(RotatedArray) target found at index :> "+findInArray(rotatedArr,target,0,rotatedArr.length-1));
    }

    private static int binarySearch(int[] arr,int start,int end, int target){
        int mid = start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(target <arr[mid]){
           return binarySearch(arr, start, mid-1, target);
        }
        else if(target > arr[mid]){
            return binarySearch(arr, mid+1, end, target);
        }
        return -1;
    }

    private static int linearSearch(int[] arr,int index,int target){
        if(index==arr.length-1){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return linearSearch(arr, index+1, target);
    }

    //search in Rotated Array
    static int findInArray(int[] arr,int target,int start,int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (arr[start] < target && arr[mid] >= target) {
                return findInArray(arr, target, start, mid - 1);
            } else {
                return findInArray(arr, target, mid + 1, end);
            }
        } else {
            if (arr[mid] < target && arr[end] >= target) {
                return findInArray(arr, target, mid + 1, end);
            } else {
                return findInArray(arr, target, start, mid - 1);
            }
        }
    }
}