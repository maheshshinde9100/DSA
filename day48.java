class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder filtered = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
           filtered.append(Character.toLowerCase(ch));
            }
        }
        int left = 0;
        int right = filtered.length() - 1;
        while(left<right){
            if(filtered.charAt(left)!= filtered.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
