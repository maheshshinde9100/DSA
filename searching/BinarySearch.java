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

    //staircase approach
    static boolean twoDSearch(int[][] arr,int target){
        if(arr==null ||arr.length==0 || arr[0].length==0) return false;
        int rows = arr.length;
        int cols  = arr[0].length;
        int row = 0;
        int col = cols-1;
        while(row < rows && col>=0){
            if(arr[row][col]==target){
                return true;
            }else if(arr[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        int[] arr = {10,20,30,40,50};
//        int temp = oneDSearch(arr, 30);
//        if(temp == -1){
//            System.out.println("Element not found :> ");
//        }else{
//            System.out.println("Element found fount at Index :> "+temp);
//        }

        //search in 2D array
        int arr2[][] = {
                {40,140,240,340},
                {60,160,260,360},
                {80,180,280,380},
                {100,200,300,400},
        };
        int target  = 180;
        //using inbuilt binarySearch() method
        for(int[] row : arr2){
            if(Arrays.binarySearch(row,target) >= 0){
                System.out.println("founded in this row :> "+Arrays.toString(row));
            }
        }

        boolean res = twoDSearch(arr2,target);
        System.out.println("is target present :> "+res);
    }

}