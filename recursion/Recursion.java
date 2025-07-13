public class Recursion {
    public static void main(String[] args) {
        // 1. reverse a number
        // 2. check the given number is palindrome or not
//        System.out.println("Reverse :> "+reverse(123)); // output: 321  //done
//        System.out.println("Is Palindrome :> "+isPalindrome(123));

        int[] arr = new int[]{4,5,6,7,1,2,3}; //search target(2) in arr
        int target = 2;
        System.out.println(findInArray(arr,target,0,arr.length-1));
    }

    //note: Always if required extra args then create helper functions
    static int reverse(int n){
        int sum = 0;
        return revHelper(n,sum);
    }
    static int revHelper(int n,int sum){
        if(n==0){
            return sum;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        return revHelper(n/10,sum);
    }
    static boolean isPalindrome(int n){
        return reverse(n)==n;
    }

    static boolean findInArray(int[] arr,int target,int start,int end) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return true;
        }
        if (arr[start] <= arr[mid]) {
            if (arr[start] < target && arr[mid] >= target) {
                return findInArray(arr, target, start, mid - 1);
            } else {
                return findInArray(arr, target, mid + 1, end);
            }
        } else {
            if (arr[mid] < target && arr[end] >= target) {
                return findInArray(arr, target, mid + 1, end);
            } else {
                return findInArray(arr, target, start, mid - 1);
            }
        }
    }

}