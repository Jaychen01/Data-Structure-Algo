package Midterm;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q4 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left.left = node3;
        root.left.right = node4;
        root.right.left = node5;
        root.right.right = node6;
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);
        TreeNode node9 = new TreeNode(10);
        TreeNode node10 = new TreeNode(11);
        TreeNode node11 = new TreeNode(12);
        root.left.left.left = node7;
        root.left.left.right = node8;
        root.left.right.left = node9;
        root.left.right.right = node10;
        root.right.left.left = node11;
        print(root);
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;
        int count = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null && count == 0) {
                continue;
            }
            if (node != null && count > 0) {
                System.out.print(node.val + ",");
                count--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                System.out.println("");
                level++;
                count = level;
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            }
        }
        System.out.println("");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
