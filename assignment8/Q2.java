package Assignment8;

public class Q2 {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (n == 1) return true;
        DisjointSetUnion set = new DisjointSetUnion(n);
        for (int[] edge : edges) {
            set.union(edge[0], edge[1]);
        }
        return set.isConnected(start, end);
    }
}
// Time complexity: O(E * log n); E is the number of edges, n is the number of vertices.
// Space complexity: O(n);
class DisjointSetUnion{
    int[] parent;
    int size;

    public DisjointSetUnion(int size) {
        this.size = size;
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
        }
    }

    public int find(int x) {
        int a = parent[x];
        if (a != x)
            return find(a);

        return a;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        if (x != y) {
            int u = find(x);
            int v = find(y);
            parent[u] = v;
        }
    }
}