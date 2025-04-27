public class StringOperations {

    // Check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Reverse a string
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    // Find the length of the string
    public static int stringLength(String str) {
        return str.length();
    }

    // Convert string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    // Convert string to lowercase
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }

    // Check if a string contains a substring
    public static boolean containsSubstring(String str, String sub) {
        return str.contains(sub);
    }

    // Find the first occurrence of a character in a string
    public static int firstOccurrence(String str, char ch) {
        return str.indexOf(ch);  // Returns the index of first occurrence
    }

    // Remove a character from a string
    public static String removeCharacter(String str, char ch) {
        return str.replace(String.valueOf(ch), "");  // Removes all occurrences of ch
    }

    public static void main(String[] args) {
        // Example to test the string operations
        String str = "madam";

        // Palindrome check
        boolean isPal = isPalindrome(str);
        System.out.println("Is palindrome: " + isPal);

        // Reverse string
        String reversed = reverseString(str);
        System.out.println("Reversed string: " + reversed);

        // Length of string
        int length = stringLength(str);
        System.out.println("Length of string: " + length);

        // Convert to uppercase
        String upper = toUpperCase(str);
        System.out.println("Uppercase string: " + upper);

        // Convert to lowercase
        String lower = toLowerCase(str);
        System.out.println("Lowercase string: " + lower);

        // Contains substring
        boolean contains = containsSubstring(str, "dam");
        System.out.println("Contains 'dam': " + contains);

        // Find first occurrence of a character
        int firstIndex = firstOccurrence(str, 'a');
        System.out.println("First occurrence of 'a': " + firstIndex);

        // Remove character 'a' from string
        String removed = removeCharacter(str, 'a');
        System.out.println("String after removing 'a': " + removed);
    }
}
