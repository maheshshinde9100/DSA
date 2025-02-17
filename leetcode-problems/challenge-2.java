import java.util.*;
// 2559. Count Vowel Strings in Ranges
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = words.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
        if (isVowelString(word, vowels)) {
             prefixSum[i] = (i == 0) ? 1 : prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = (i == 0) ? 0 : prefixSum[i - 1];
            }
        }
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            if (left == 0) {
                result[i] = prefixSum[right];
            } else {
                result[i] = prefixSum[right] - prefixSum[left - 1];
            }
        }
        
        return result;
    }
    private boolean isVowelString(String word, Set<Character> vowels) {
        return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1));
    }
}
