package Assignment7;

import java.util.ArrayList;
import java.util.List;

public class Q4 {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            char[] arr = word.toCharArray();
            for (char ch : arr) {
                int i = ch - 'a';
                if (curr.children[i] == null) {
                    curr.children[i] = new TrieNode();
                }
                curr = curr.children[i];
            }
            curr.word = word;
        }
        return root;
    }

    int m, n;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        TrieNode root = buildTrie(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = board[i][j] - 'a';
                if (root.children[k] != null) {
                    visited[i][j] = true;
                    dfs(board, i, j, root.children[k], res);
                    visited[i][j] = false;
                }
            }
        }
        return res;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(char[][] board, int x, int y, TrieNode node, List<String> res) {
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (isValid(newX, newY) && !visited[newX][newY]) {
                int k = board[newX][newY] - 'a';
                if (node.children[k] != null) {
                    visited[newX][newY] = true;
                    dfs(board, newX, newY, node.children[k], res);
                    visited[newX][newY] = false;
                }
            }
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
// Time complexity: O(m * n * 3^L); L is the length of the word to be matched.
// Space complexity: O(N); N is the total number of letters in the dictionary.