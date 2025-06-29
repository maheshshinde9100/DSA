package Patterns.FastAndSlowPointer;

public class IsHappyNumber {

    public static void main(String[] args) {
        int n = 19;
        System.out.println("For "+n+":> "+isHappy(n));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(true){
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
            if(slow==fast){
                break;
            }
        }
        return slow==1;
    }

    public static int findSquareSum(int num){
        int sum  = 0;
        while(num > 0){
            int digit = num%10;
            sum += digit*digit;
            num = (int) Math.floor(num/10);
        }
        return sum;
    }
}
