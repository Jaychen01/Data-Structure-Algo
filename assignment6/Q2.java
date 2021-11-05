package Assignment6;

import java.util.Stack;

public class Q2 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.empty() && !stack2.empty()) {
            if (dfs(stack1) != dfs(stack2)) {
                return false;
            }
        }
        return stack1.empty() && stack2.empty();
    }

    private int dfs(Stack<TreeNode> stack) {
        while(true) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            if (node.right == null && node.left == null) return node.val;
        }
    }
}
// Time complexity: O(n1 + n2); n1, n2 represent the number of nodes in the two given trees.
// Space complexity: O(h1 + h2); h1, h2 represent the height of the two given trees