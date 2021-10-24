package Midterm;

public class Q3 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;
        System.out.println(findMid(head).val);
    }

    public static ListNode findMid(ListNode head){
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                fast = head;
            }
        }

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        int count1 = 0;
        ListNode node = head;
        while(node != slow){
            node = node.next;
            ++count1;
        }
        int count2 = 0;
        ListNode node2 = slow;
        while(node2.next != fast) {
            node2 = node2.next;
            ++count2;
        }
        int mid = (count1 + count2)/2;
        while (mid > 0) {
            head = head.next;
            mid--;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}