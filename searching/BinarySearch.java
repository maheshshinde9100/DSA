import java.util.Arrays;

public class BinarySearch{
    static int oneDSearch(int[] arr,int key){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(key == arr[mid]){
                return mid;
            }
            if(key < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    static int[] twoDSearch(int[][] arr,int key){
        int start = 0;
        int end = arr[0].length-1;
        while(start<=end){
           //remaining
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int temp = oneDSearch(arr, 30);
        if(temp == -1){
            System.out.println("Element not found :> ");
        }else{
            System.out.println("Element found fount at Index :> "+temp);
        }

        //binary search in 2D array
        int arr2[][] = {
            {100,200,300,400},
            {80,180,280,380},
            {60,160,260,360},
            {40,140,240,340}
        };

        int res[] =twoDSearch(arr2,180);
        System.out.println(Arrays.toString(res));
    }
}