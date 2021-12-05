package Assignment8;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q7 {
    private int[] xBias = {1, -1,0 ,0};
    private int[] yBias = {0, 0, 1, -1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        int freshNum = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    freshNum++;
                } else if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty() && freshNum != 0) {
            time++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int poll = queue.poll();
                int x = poll / n;
                int y = poll % n;
                for (int p = 0; p < 4; p++) {
                    int newX = x + xBias[p];
                    int newY = y + yBias[p];
                    if (newX < 0 || newX > m - 1 || newY < 0 || newY > n - 1 || grid[newX][newY] != 1) {
                        continue;
                    }
                    freshNum--;
                    grid[newX][newY] = 2;
                    queue.offer(newX * n + newY);
                }
            }
        }
        return freshNum == 0 ? time : -1;
    }
}
// Time complexity: O(N); N is the size of the given grid.
// Space complexity: O(N);