package Assignment6;

public class Q7 {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
// Time complexity: O(n); n represents the number of nodes in the given tree.
// Space complexity: O(n);