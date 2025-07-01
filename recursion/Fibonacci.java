public class Fibonacci {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibb(n));
    }
    static int fibb(int n){
        if(n<2){
            return n;
        }
        return fibb(n-1) + fibb(n-2);  
        //for each function call: firstly call fibb(n-1) recursively then followed by fibb(N-2)
    }


}