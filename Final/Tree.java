package Final;


import java.util.*;

public class Tree {
    //private TreeNode root;
    public static TreeNode buildTree(int inOrder[], int level[]) {
        TreeNode root = new TreeNode();
        return constructTree(root, level, inOrder, 0, inOrder.length - 1);
    }

    private static TreeNode constructTree(TreeNode root, int[] levelOrder, int[] inOrder, int inOrderStart, int inEnd) {
        if (inOrderStart > inEnd) return null;
        if (inOrderStart == inEnd) return new TreeNode(inOrder[inOrderStart]);
        int index = 0;
        boolean isFound = false;
        for (int i = 0; i < levelOrder.length - 1; i++) {
            int value = levelOrder[i];
            for (int j = inOrderStart; j < inEnd; j++) {
                if (value == inOrder[j]) {
                    root = new TreeNode(value);
                    index = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound == true) break;
        }
        root.buildLeft(constructTree(root, levelOrder, inOrder, inOrderStart, index - 1));
        root.buildRight(constructTree(root, levelOrder, inOrder, index + 1, inEnd));
        return root;
    }

    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) {
        int level[] = new int[] {1,2,3,4,6,7};
        int inOrder[] = new int[] {4,2,1,6,3,7};
        TreeNode node = buildTree(inOrder, level);
        printInorder(node);
    }
}

