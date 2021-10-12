package Assignment4;

public class Q1 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
// Time complexity: O(1);
// Space complexity: O(1);