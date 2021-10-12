package Assignment4;

public class Q5 {
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }
}
// Time complexity: O(n);
// Space complexity: O(1);


