// GeeksForGeeks problem -- used two pointer technique here
class NextPermutation {
    void nextPermutation(int[] arr) {
        // code here
        int length = arr.length;
        int i = arr.length -2;
        
        while(i>=0 && arr[i]>=arr[i+1]){
            i--;
        }
        
        if(i>=0){
            for(int j=length-1;j>i;j--){
                if(arr[j]>arr[i]){
                    swap(arr,i,j);
                    break;
                }
            }
        }
        int start = i+1;
        int end = length-1;
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    
    private void swap(int arr[], int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
