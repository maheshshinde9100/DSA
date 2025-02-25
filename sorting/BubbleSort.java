/*Also known as Sinking sort / Exchange sort 
    Space Complexity = O(1) //constant - extra space not required
    Time Complexity = O(N) best case - if making ascending,
                      O(N^2) worst case - if making descending
*/
import java.util.Arrays;
public class BubbleSort {
    public static void main(String[] args){
        int[] arr = {10,5,100,43,50,88};
        boolean swapped;
        // ascending
        for(int i=0;i<arr.length;i++){
            swapped = false;
            for(int j=1;j<arr.length-1;j++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;   
                    swapped = true;
                }
            }
            if(!swapped){ //!false  = true
                break;
            }
        }
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
