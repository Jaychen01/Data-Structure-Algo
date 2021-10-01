package Assignment3;

public class Q1 {

    // Time complexity: O(n + m);
    // Space complexity: O(1);
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null) {
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }
        return pointerA;
    }
}
