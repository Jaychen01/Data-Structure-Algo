package Assignment6;

public class Q1 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode root3 = new TreeNode(root1.val + root2.val);
        root3.left = mergeTrees(root1.left, root2.left);
        root3.right = mergeTrees(root1.right, root2.right);
        return root3;
    }
}
// Time complexity: O(min(m,n)); m, n represent the number of nodes in the two given trees.
// Space complexity: O(min(m,n));

class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
}