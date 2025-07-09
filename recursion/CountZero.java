package recursion;

public class CountZero {
    public static void main(String[] args) {
        int n = 1000403200; //6 zeroes
        System.out.println(countZero(n)); //6
    }

    static int countZero(int n){
        int count = 0;
        return countHelper(n,count);
    }

    static int countHelper(int n,int count){
        if(n==0){
            return count;
        }
        int rem = n%10;
        if(rem == 0){
            count++;
        }
        return countHelper(n/10, count);
        
    }
}
