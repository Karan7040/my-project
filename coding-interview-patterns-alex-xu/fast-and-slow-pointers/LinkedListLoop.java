import java.util.HashSet;
import java.util.Set;

public class LinkedListLoop {
    public boolean hasLoop(Node node) {
        Set<Node> set = new HashSet<>();

        while (node != null) {
            if (!set.add(node)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean hasLoopOptimized(Node head) {
        Node fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
