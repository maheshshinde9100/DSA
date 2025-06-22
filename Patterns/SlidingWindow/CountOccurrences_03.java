package Patterns.SlidingWindow;

import java.util.HashMap;

/*3. Count Occurrences of Anagrams
Problem: Given a text and a pattern, return the count of occurrences of anagrams of the pattern in the text.
Input:
txt = "forxxorfxdofr", pat = "for"
Expected Output: 3
 (Explanation: Anagrams of "for" are "for", "orf", "fro", etc.)
 */
public class CountOccurrences_03 {
    public static void main(String[] args) {
        String txt="forxxorfxdofr";
        String pat = "for";
        System.out.println(countAnagramOccurrences(txt,pat));
    }
    public static int countAnagramOccurrences(String txt, String pat){
        int k = pat.length();
        int count= k;
        int ans = 0;
        int i=0,j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int x=0;x<pat.length();x++){
            char c = pat.charAt(x);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while(j < txt.length()) {
            char endChar = txt.charAt(j);
            if(map.containsKey(endChar)){
                map.put(endChar,map.get(endChar)-1);
                if(map.get(endChar)==0){
                    count--;
                }
            }else
                if(j-i+1 < k){
                    j++;
                }
            if(j-i+1==k) {
                if (count == 0) {
                    ans++;
                }
                char startChar = txt.charAt(i);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) == 1) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
