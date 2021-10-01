package Assignment3;

public class Q5 {

    // Time complexity: O(N);
    // Space complexity: O(1);
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow =slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
