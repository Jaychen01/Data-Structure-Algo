package Assignment8;

import java.util.LinkedList;
import java.util.Queue;

public class Q3 {
    private int[] xBias = {0, 0, 1, -1};
    private int[] yBias = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int count  = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '2';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] num = queue.poll();
            i = num[0];
            j = num[1];
            for (int k = 0; k < xBias.length; k++) {
                int newI = i + xBias[k];
                int newJ = j + yBias[k];
                if(newI < 0 || newI > m - 1 || newJ < 0 || newJ > n - 1 || grid[newI][newJ] != '1') {
                    continue;
                }
                queue.offer(new int[]{newI, newJ});
                grid[newI][newJ] = '2';
            }
        }
    }
}
// Time complexity: O(m * n); m is the number of rows and n is the number of columns.
// Space complexity: O(min(m, n));