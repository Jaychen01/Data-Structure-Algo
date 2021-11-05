package Assignment6;

public class Q5 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;

        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
}
// Time complexity: O(n); n represents the number of nodes in the given tree.
// Space complexity: O(n);