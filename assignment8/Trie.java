package Assignment8;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = helper(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return helper(prefix) != null;
    }

    public TrieNode helper(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length() && node != null; i++) {
            char c = s.charAt(i);
            node = node.children[c - 'a'];
        }
        return node;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}
// Time complexity: O(m); L is the length of the String word.
// Space complexity: O(m) for insertion and O(1) for search.