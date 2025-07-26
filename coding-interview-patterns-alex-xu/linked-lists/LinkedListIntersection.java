import java.util.HashSet;
import java.util.Set;

public class LinkedListIntersection {
    public Node intersectionBruteForce(Node headA, Node headB) {
        Set<Node> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public Node intersection(Node headA, Node headB) {
        Node a = headA;
        Node b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
