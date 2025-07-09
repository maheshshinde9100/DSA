package recursion;
public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n, 1));
    }
    static int factorial(int n,int fact){
        if(n==1) {
            return fact;
        }
        return factorial(n-1, fact*n);
    }
}
