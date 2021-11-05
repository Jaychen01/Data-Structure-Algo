package Assignment6;

public class Q3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
// Time complexity: O(n); n represents the number of nodes in the given tree.
// Space complexity: O(h); h represents the height of the given tree. Worst: O(n)
