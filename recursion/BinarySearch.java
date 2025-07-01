public class BinarySearch{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 9;
        System.out.println(binarySearch(arr,0,arr.length-1,target));
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
}