package Patterns.SlidingWindow;

import java.util.Arrays;
import java.util.*;
public class SlidingWindow {
    public static void main(String[] args) {
//        int[] arr = {1,2,6,2,2,5};
//        int k = 3;
//        System.out.println(maximumSubarraySum(arr,k));

        String txt = "forxxorfxdofr", pat = "for";
//        System.out.println(search(pat,txt)); // brute force
        System.out.println(search1(pat,txt)); // Optimized force

    }
    public static int maximumSubarraySum(int[] arr, int k){
        int i =0;
        int j = 0;
        int currSum = 0;
        int maxSum = 0;
        while(j< arr.length){
            currSum+=arr[j];
            if(j-i+1==k){
                maxSum = Math.max(currSum,maxSum);
                currSum -= arr[i];
                i++;
            }
            j++;
        }
        return maxSum;
    }

    static int search(String pat, String txt) {
        // brute force for counting pattern ANAGRAM occurences in txt
        // optimized search1()
        int i = 0;
        int j = 0;
        int k = pat.length();

        char[] carr1 = pat.toCharArray();
        Arrays.sort(carr1);
        int count = 0;
        StringBuffer temp = new StringBuffer();
        while (j < txt.length()) {
            temp.append(txt.charAt(j));
            if (j - i + 1 == k) {
                char[] carr2 = temp.toString().toCharArray();
                Arrays.sort(carr2);

                if (Arrays.equals(carr1, carr2)) {
                    count++;
                }
                temp.deleteCharAt(0);
                i++;
            }
            j++;
        }
        return count;
    }
    //optimized approach
     static int search1(String pat,String txt) {
                Map<Character, Integer> map = new HashMap<>();
                int i = 0;
                int j = 0;
                int ans = 0;
                int n = txt.length();
                int k = pat.length();

                for (int x = 0; x < k; x++) {
                    char c = pat.charAt(x);
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }

                int count = map.size();
                char[] charArr = txt.toCharArray();

                while (j < n) {
                    char ch = charArr[j];
                    if (map.containsKey(ch)) {
                        map.put(ch, map.get(ch) - 1);
                        if (map.get(ch) == 0) {
                            count--;
                        }
                    }

                    if (j - i + 1 < k) {
                        j++;
                    } else if (j - i + 1 == k) {
                        if (count == 0) {
                            ans++;
                        }

                        char out = charArr[i];
                        if (map.containsKey(out)) {
                            map.put(out, map.get(out) + 1);
                            if (map.get(out) == 1) {
                                count++;
                            }
                        }
                        i++;
                        j++;
                    }
                }

                return ans;
            }
}
