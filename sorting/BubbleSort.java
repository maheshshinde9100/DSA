/*Also known as Sinking sort / Exchange sort 
    Space Complexity = O(1) //constant - extra space not required
    Time Complexity = O(N) best case - if making ascending,
                      O(N^2) worst case - if making descending
*/
import java.util.Arrays;
public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {10,5,100,43,50,88};
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
