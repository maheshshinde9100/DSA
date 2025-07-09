public class Recursion {
    public static void main(String[] args) {
        // 1. reverse a number
        // 2. check the given number is palindrome or not
        System.out.println("Reverse :> "+reverse(123)); // output: 321  //done
        System.out.println("Is Palindrome :> "+isPalindrome(123));
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
}