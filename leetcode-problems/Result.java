import java.util.*;
class Result {
    public static void plusMinus(List<Integer> arr) {
    // Write your code here
    int p =0;
    int n=0;
    int z=0;
    int s = arr.size();
    for(int i=0;i<arr.size();i++){
        if(arr.get(i)>0){
            p=p+1;
        }else if(arr.get(i)<0){
            n=n+1;
        }else if(arr.get(i)==0){
            z=z+1;
        }
    }
    float res1 = (float) p/s;
    float res2 =  (float) n/s;
    float res3 = (float) z/s;
    System.out.println(res1+"\n"+res2+"\n"+res3);
    }

}