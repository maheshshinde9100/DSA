/*Also known as Sinking sort / Exchange sort 
    Space Complexity = O(1) //constant - extra space not required
    Time Complexity = O(N) best case - if making ascending,
                      O(N^2) worst case - if making descending
*/
import java.util.Arrays;
public class BubbleSort {
    public void sort(int[] arr,int n){
        if(n==1) return;
        int count = 0;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                swap(arr,i,i+1);
                count++;
            }
        }
        if(count == 0) return;
        sort(arr, n-1);
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int[] arr = {10,5,100,43,50,5,88};
        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]>arr[j]){
        //             int temp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
        // }
        BubbleSort obj= new BubbleSort();
        obj.sort(arr,arr.length);
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
