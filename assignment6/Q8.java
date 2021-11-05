package Assignment6;

import java.util.*;

public class Q8 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        queue.offer(root);
        cols.offer(0);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = cols.poll();
            map.computeIfAbsent(col, k -> new ArrayList<Integer>()).add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                cols.offer(col - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                cols.offer(col + 1);
            }
        }
        return new ArrayList(map.values());
    }
}
// Time complexity: O(n log n); n represents the number of nodes in the given tree.
// Space complexity: O(n);