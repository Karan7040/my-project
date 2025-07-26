import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Node head, tail;
    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Integer get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        this.remove(node);
        this.insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.previous);
        }
        insertToFront(new Node(value));
    }

    private void insertToFront(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.next.previous = node.previous;
        node.previous.next = node.next;
    }


}

