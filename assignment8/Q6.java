package Assignment8;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q6 {
    private int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                if (x == n - 1 && y == n - 1) {
                    return level + 1;
                }
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY] == 0) {
                        queue.offer(new int[]{newX,newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
// Time complexity: O(N); N is the size of the given grid.
// Space complexity: O(N);