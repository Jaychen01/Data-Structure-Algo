package Assignment6;

public class Q6 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null || n1.val != n2.val) return false;

        return dfs(n1.left, n2.right) && dfs(n1.right, n2.left);
    }
}
// Time complexity: O(n); n represents the number of nodes in the given tree.
// Space complexity: O(n);