import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {30,20,10,40,33,5};
        System.out.println("Before Sort: > "+Arrays.toString(arr));

        for(int i=0;i<arr.length;i++){
            int min_index = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        System.out.println("After Selection sort :>  "+Arrays.toString(arr));
    }
}
