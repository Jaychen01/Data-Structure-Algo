package Final;

public class Q2 {
    public static boolean isFoldable(TreeNode node) {
        boolean res;
        if (node == null) return true;
        mirror(node.left);
        res = isSame(node.left, node.right);
        mirror(node.left);
        return res;
    }

    private static boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)  return true;
        if (node1 != null && node2 != null && isSame(node1.left, node2.left) && isSame(node1.right, node2.right)) {
            return true;
        }
        return false;
    }

    private static void mirror(TreeNode node) {
        if (node == null) return;
        else {
            TreeNode temp;
            mirror(node.left);
            mirror(node.right);
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        //root.right.right = new TreeNode(7);
        System.out.println(isFoldable(root));
    }
}
