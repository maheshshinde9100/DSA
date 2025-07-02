public class BinarySearch{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 9;
        System.out.println("Binary Search : index > "+ binarySearch(arr,0,arr.length-1,target));
        System.out.println("Linear Search : index > " +linearSearch(arr,0,target));

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
}