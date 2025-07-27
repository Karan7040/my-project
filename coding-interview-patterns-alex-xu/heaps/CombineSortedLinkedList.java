import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CombineSortedLinkedList {
    public Node combineSortedLinkedList(List<Node> nodes) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        Node dummy = new Node(0);
        Node temp = dummy;
        for (Node node : nodes) {
            minHeap.offer(node);
        }

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            temp.next = node;
            temp = temp.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;

    }
}
