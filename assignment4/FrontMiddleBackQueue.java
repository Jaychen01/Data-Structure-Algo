package Assignment4;

public class FrontMiddleBackQueue {
    DoubleListNode dummy;
    DoubleListNode mid;
    int size = 0;

    public FrontMiddleBackQueue() {
        dummy = new DoubleListNode(-1);
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public void pushFront(int val) {
        DoubleListNode node = new DoubleListNode(val);
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next = node;
        node.next.prev = node;
        if (size == 0) {
            mid = node;
        } else if (size % 2 == 1) {
            mid = mid.prev;
        }
        size++;
    }

    public void pushMiddle(int val) {
        if (size % 2 == 0) {
            pushAfterMid(val);
        } else {
            pushBeforeMid(val);
        }
    }

    private void pushAfterMid(int val) {
        if (size == 0) {
            pushFront(val);
        } else {
            DoubleListNode node = new DoubleListNode(val);
            node.next = mid.next;
            node.prev = mid;
            mid.next = node;
            node.next.prev = node;

            mid = node;
            size++;
        }
    }

    private void pushBeforeMid(int val) {
        DoubleListNode node = new DoubleListNode(val);
        node.next = mid;
        node.prev = mid.prev;
        mid.prev.next= node;
        mid.prev = node;

        mid = node;
        size++;
    }

    public void pushBack(int val) {
        DoubleListNode node = new DoubleListNode(val);
        node.prev = dummy.prev;
        node.next = dummy;
        dummy.prev = node;
        node.prev.next = node;

        if (size == 0) {
            mid = node;
        } else if (size > 0 && size % 2 == 0) {
            mid = mid.next;
        }
        size++;
    }

    public int popFront() {
        if (size > 0) {
            DoubleListNode node = dummy.next;
            dummy.next = node.next;
            node.next.prev = dummy;
            if (size % 2 == 0) {
                mid = mid.next;
            }
            size--;
            return node.val;
        }
        return -1;
    }

    public int popMiddle() {
        if (size > 0) {
            int value = mid.val;
            mid.prev.next = mid.next;
            mid.next.prev = mid.prev;
            if (size % 2 == 1) {
                mid = mid.prev;
            } else {
                mid = mid.next;
            }
            size--;
            return value;
        }
        return -1;
    }

    public int popBack() {
        if (size > 0) {
            DoubleListNode node = dummy.prev;
            dummy.prev = node.prev;
            node.prev.next = dummy;
            if (size % 2 == 1) {
                mid = mid.prev;
            }
            size--;
            return node.val;
        }
        return -1;
    }
}

// Time complexity: O(1);
// Space complexity: O(n);