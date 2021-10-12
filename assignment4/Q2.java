package Assignment4;

public class Q2 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node curr = head;
        do {
            if (curr.val <= curr.next.val) {
                if (insertVal >= curr.val && insertVal <= curr.next.val)
                    break;
            } else {
                if (insertVal > curr.val || insertVal < curr.next.val)
                    break;
            }
            curr = curr.next;
        } while(curr != head);

        Node temp = curr.next;
        curr.next = new Node(insertVal,temp);

        return head;
    }
}
// Time complexity: O(n);
// Space complexity: O(1);

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

