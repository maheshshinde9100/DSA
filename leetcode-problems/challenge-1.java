//1422. Maximum Score After Splitting a String
class Solution {
    public int maxScore(String s) {
         int maxScore = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            int count1 = 0, count2 = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') {
                    count1++;
                }
            }
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    count2++;
                }
            }
maxScore = Math.max(maxScore, count1 + count2);
        }
        return maxScore;
    }
}
