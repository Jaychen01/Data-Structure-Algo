package Assignment3;

public class Q3 {


    // Time complexity: O(MAX(m,n));
    // Space complexity: O(MAX(m,n));
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null){
            int n1 = l1 == null ? 0 : l1.value;
            int n2 = l2 == null ? 0 : l2.value;
            int sum = n1 + n2 + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            curr.next = new ListNode(sum);

            curr = curr.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
            if (carry == 1){
                curr.next = new ListNode(1);
            }
        }
        return dummy.next;
    }


}
