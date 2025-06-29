import java.util.Arrays;
class Anagram_Palindrome {
    public static void main(String[] args) {
        
    String s1 = "mahesh",s2="shmhae";
    System.out.println("is anagram:("+s1+","+s2+") :> "+anagram(s1,s2));
    System.out.println("is palindrome: "+s1+" :>"+palindrome(s1));
    }
    
    static boolean palindrome(String s1){
        boolean ch = true;
        char temp1[] = s1.toCharArray();
        int i = s1.length()-1;
        for(Character c: s1.toCharArray()){
            if(temp1[i]!=c){
                ch = false;
                break;
            }
            i--;
        }
        return ch;
    }
    
    static boolean anagram(String s1, String s2){
         if(s1.length() != s2.length()){
            return false;
        }
        int n = s1.length();
        boolean ch = true;
        
        char temp1[] = s1.toCharArray();
        char temp2[] = s2.toCharArray();
        
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        
        for(int i=0;i<n;i++){
            if(temp1[i]!=temp2[i]){
                ch = false;
                break;
            }
        }
    return ch;
    }
}
