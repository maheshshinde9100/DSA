public class SumOfDigits {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(sumOfDigits(n,0));
    }
    
    static int sumOfDigits(int n,int sum){
        if(n ==0){
            sum += n;
            return sum;
        }
        sum += n%10;
        return sumOfDigits(n/10, sum);
    }
}
