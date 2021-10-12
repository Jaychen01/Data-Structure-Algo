package Assignment4;

public class Q4 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode dummy0 = new ListNode();
        dummy0.next = head;
        ListNode prev = dummy0;

        int i = 1;
        for (; i < left; i++) {
            prev = head;
            head = head.next;
        }
        ListNode curr = head;

        ListNode dummy1 = null;
        ListNode dummy2 = null;
        for (; i <= right; i++) {
            dummy2 = head.next;
            head.next = dummy1;
            dummy1 = head;
            head = dummy2;

        }

        prev.next = dummy1;
        curr.next = dummy2;

        return dummy0.next;
    }
}
// Time complexity: O(n);
// Space complexity: O(1);