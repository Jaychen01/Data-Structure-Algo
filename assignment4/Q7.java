package Assignment4;

public class Q7 {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode();
        PolyNode curr = dummy;
        while (poly1 != null || poly2 != null) {
            int a = poly1 == null ? -1 : poly1.power;
            int b = poly2 == null ? -1 : poly2.power;
            if (a > b) {
                curr.next = new PolyNode(poly1.coefficient, poly1.power);
                poly1 = poly1.next;
                curr = curr.next;
            } else if (a < b) {
                curr.next = new PolyNode(poly2.coefficient, poly2.power);
                poly2 = poly2.next;
                curr = curr.next;
            } else {
                if (poly1.coefficient + poly2.coefficient != 0) {
                    curr.next = new PolyNode(poly1.coefficient + poly2.coefficient, poly1.power);
                    curr = curr.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
        }
        return dummy.next;
    }
}
// Time complexity: O(m+n), m, n represent the number of nodes in poly1, poly2;
// Space complexity: O(m+n);

class PolyNode {

    int coefficient, power;
    PolyNode next = null;

    PolyNode() {}
    PolyNode(int x, int y) {
        this.coefficient = x;
        this.power = y;
    }
    PolyNode(int x, int y, PolyNode next) {
        this.coefficient = x;
        this.power = y;
        this.next = next;
    }
}

