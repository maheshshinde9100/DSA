public class CountZero {
    public static void main(String[] args) {
        int n = 1003010; //4 zeroes
        System.out.println(countZero(n,0));
    }

    static int countZero(int n,int count){
        if(n== 0 && count==0) return 1;
        if(n==0) return count;
        count += (n%10==0) ?1 :0;
        return countZero(n/10, count);
    }
}
