public class Basic {
    static String swap(int a, int b){
    a = a^b;
    b = a^b;
    a = a^b;
    return "A="+a+", B="+b;
   //swap without using extra variable
    }
    
    // finding is prime or not
    static boolean isPrime(int x){
        for(int i=2;i<Math.sqrt(x);i++){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }
    
    //simple fibonacci series logic
    static void fibonacci(int x){
        int a = 0;
        int b = 1;
        int c = 0;
        while(c<=x){
            System.out.print(c+"\t");
            c = a+b;
            a = b;
            b = c;
        }
    }
    public static void main(String[] args) {
        System.out.println(swap(1,2));
        System.out.println(isPrime(11));
        fibonacci(100);
    }
}