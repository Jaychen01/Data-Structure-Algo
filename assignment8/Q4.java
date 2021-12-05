package Assignment8;

public class Q4 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] matrix, int i, boolean[] visited) {
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(matrix, j, visited);
            }
        }
    }
}
// Time complexity: O(n * n); n * n is the size of the matrix.
// Space complexity: O(n);