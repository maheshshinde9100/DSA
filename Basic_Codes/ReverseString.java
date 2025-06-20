public class ReverseString {
    public static void main(String[] args){
        String str = "Mahesh";
        System.out.println(reverse(str));
    }

    //used Two pointer technique
    public static String reverse(String str){
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            swap(arr,left,right);
            left++;
            right--;
        }
        
        return new String(arr);
    }
    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
