package recursion;

public class ReverseNumberAndString {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(reverse(n,""));
        String str = "mahesh";
        System.out.println(reverseStr(str, new String(), str.length()-1));
    }
    //reverse number
    static String reverse(int n,String rev){
        if(n==0){
            return rev;
        }
        return reverse(n/10, rev+=n%10);

        // return reverseNum(n / 10, rev * 10 + n % 10); // put return type int for function
    }

    //reverse string-->
    static String reverseStr(String s, String rev,int count){
        if(count < 0){
            return rev.toString();
        }
        rev += s.charAt(count);
         return reverseStr(s, rev, count-1);
    }
}
