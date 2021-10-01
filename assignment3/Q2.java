package Assignment3;

public class Q2 {

    // Time complexity: O(N);
    // Space complexity: O(1);
    public ListNode removeElements(ListNode head, int val){
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        while (prev.next != null){
            if (prev.next.value == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummy.next;

    }

}
