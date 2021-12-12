package Final;


import java.util.*;

public class Tree {

    public static TreeNode buildTree(int inOrder[], int level[]) {
        TreeNode root = new TreeNode();
        return constructTree(root, level, inOrder, 0, inOrder.length - 1);
    }

    private static TreeNode constructTree(TreeNode root, int[] levelOrder, int[] inOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) return null;
        if (inOrderStart == inOrderEnd) return new TreeNode(inOrder[inOrderStart]);
        int index = 0;

        for (int i = 0; i < levelOrder.length - 1; i++) {
            int value = levelOrder[i];
            for (int j = inOrderStart; j < inOrderEnd; j++) {
                if (value == inOrder[j]) {
                    root = new TreeNode(value);
                    index = j;
                    break;
                }
            }
        }
        root.left = constructTree(root, levelOrder, inOrder, inOrderStart, index - 1);
        root.right = constructTree(root, levelOrder, inOrder, index + 1, inOrderEnd);
        return root;
    }

    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) {
        int level[] = new int[] {1,2,3,4,5,7};
        int inOrder[] = new int[] {4,2,5,1,3,7};
        TreeNode node = buildTree(inOrder, level);
        printInorder(node);
    }
}

