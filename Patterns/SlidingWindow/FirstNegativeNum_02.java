package Patterns.SlidingWindow;

import java.util.*;

public class FirstNegativeNum_02 {
    public static void main(String[] args) {
        int[] arr = {12,-1, -7, 8, 15, 30, 16, 28};
        int k = 3;
        //expected op:  [-1,-1,-7,0,0,0]
        System.out.println(Arrays.toString(getFirstNegativeNumInWindow(arr, k)));
    }
    static int[] getFirstNegativeNumInWindow(int[] arr, int k){
        int i = 0;
        int j = 0;
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while(j<arr.length){
            if(arr[j]<0){
                q.add(arr[j]);
            }
            if(j-i+1==k){
                if(!q.isEmpty()){
                    res.add(q.peek());
                }else{
                    res.add(0);
                }
                if(!q.isEmpty() && q.peek()==arr[i]){
                    q.poll();
                }
                i++;
            }
            j++;
        }

        int[] temp  = new int[res.size()];
        int count = 0;
        for(int x: res){
            temp[count] = x;
            count++;
        }
        return temp;
    }
}
