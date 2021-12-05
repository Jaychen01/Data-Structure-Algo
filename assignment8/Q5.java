package Assignment8;

import java.util.ArrayList;
import java.util.List;

public class Q5 {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] visited = new boolean[n];
        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(list, visited, i);
            }
        }
        return count;
    }

    private void dfs(List<Integer>[] list, boolean[] visited, int start) {
        visited[start] = true;
        for (int i : list[start]) {
            if (!visited[i]) {
                dfs(list, visited, i);
            }
        }
    }
}
// Time complexity: O(E + n); E is the number of edges, n is the number of vertices.
// Space complexity: O(E + n);