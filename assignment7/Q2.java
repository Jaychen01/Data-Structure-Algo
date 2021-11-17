package Assignment7;

public class Q2 {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        helper(n, 1, visited);
        return count;
    }

    private void helper(int n, int index, boolean[] visited) {
        if (index > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (index % i == 0 || i % index == 0)) {
                visited[i] = true;
                helper(n, index + 1, visited);
                visited[i] = false;
            }
        }
    }
}
// Time complexity: O(n!);
// Space complexity: O(n);
