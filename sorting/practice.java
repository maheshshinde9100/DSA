import java.util.Arrays;

public class practice {
    public static void main(String[] args) {
        int[] arr = {10,4,3,-5,20,5,1};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    private static int[] mergeSort(int[] arr){
        if(arr.length==1) return arr;

        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0, mid));
        int[] right =  mergeSort(Arrays.copyOfRange(arr,mid, arr.length));

        return merge(arr,left,right);
    }
    private static int[] merge(int[] arr,int[] left, int[] right){
        int i=0,j=0,k=0;
        int[] mergedArr = new int[left.length+right.length];

        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                mergedArr[k] = left[i];
                i++;
            }else{
                mergedArr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<left.length){
            mergedArr[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            mergedArr[k] = right[j];
            j++;
            k++;
        }
        return mergedArr;
    }
}
