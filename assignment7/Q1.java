package Assignment7;

public class Q1 {
    private boolean[][] visited;
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (isValid(newX, newY) && !visited[newX][newY]) {
                    if (dfs(board, word, newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
// Time complexity: O(m * n * 3^L); L is the length of the word to be matched.
// Space complexity: O(m * n);