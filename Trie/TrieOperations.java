package Trie;

public class TrieOperations {

        // Node structure for Trie
        static class TrieNode {
            TrieNode[] children; // Array to store links to child nodes (assuming lowercase English letters)
            boolean isEndOfWord; // Flag indicating if the node marks the end of a word

            public TrieNode() {
                children = new TrieNode[26]; // Initialize children array for 26 lowercase letters
                isEndOfWord = false;
            }
        }

        private TrieNode root; // The root of the Trie

        public TrieOperations() {
            root = new TrieNode(); // Initialize the Trie with an empty root node
        }

        // Inserts a word into the Trie
        public void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a'; // Calculate index for the character
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode(); // Create a new node if not present
                }
                current = current.children[index]; // Move to the next node
            }
            current.isEndOfWord = true; // Mark the end of the word
        }

        // Searches for a word in the Trie
        public boolean search(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    return false; // Word not found
                }
                current = current.children[index];
            }
            return current.isEndOfWord; // Check if the last node marks the end of a word
        }

        // Checks if a given prefix exists in the Trie
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    return false; // Prefix not found
                }
                current = current.children[index];
            }
            return true; // Prefix found
        }

    public static void main(String[] args) {
        TrieOperations obj  = new TrieOperations();
        String str = "Mahesh";
        // Always store in lowercase
        obj.insert(str.toLowerCase());
        System.out.println("Inserted word : " + str);

        System.out.println("Search 'mahesh' :> " + obj.search("mahesh"));
        System.out.println("Search 'he' :> " + obj.search("he"));   // false (not a full word)
        System.out.println("Starts with 'ma' ? :> " + obj.startsWith("ma")); // true
        System.out.println("Starts with 'he' ? :> " + obj.startsWith("he")); // false
    }
}

