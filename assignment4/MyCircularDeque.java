package Assignment4;

public class MyCircularDeque {
    private int k = 0;
    private int size = 0;
    private DoubleListNode dummyH = null;

    public MyCircularDeque(int k) {
        this.k = k;
        dummyH = new DoubleListNode(-1);
        dummyH.next = dummyH;
        dummyH.prev = dummyH;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        DoubleListNode node = new DoubleListNode(value);
        node.prev = dummyH;
        node.next = dummyH.next;
        dummyH.next = node;
        node.next.prev = node;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        DoubleListNode node = new DoubleListNode(value);
        node.prev = dummyH.prev;
        dummyH.prev = node;
        node.next = dummyH;
        node.prev.next = node;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        dummyH.next = dummyH.next.next;
        dummyH.next.prev = dummyH;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        dummyH.prev = dummyH.prev.prev;
        dummyH.prev.next = dummyH;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : dummyH.next.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : dummyH.prev.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}

// Time complexity: O(1);
// Space complexity: O(n);
