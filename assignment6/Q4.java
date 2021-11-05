package Assignment6;

public class Q4 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        int diff = Math.abs(leftHeight - rightHeight);
        if (leftHeight == -1 || rightHeight == -1 || diff > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
// Time complexity: O(n); n represents the number of nodes in the given tree.
// Space complexity: O(n);
