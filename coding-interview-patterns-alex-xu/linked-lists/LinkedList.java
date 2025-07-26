public class LinkedList {
    Node head;
    int size;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            size++;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(value);
        size++;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void add(int position, int value) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Out of Bound Exception");
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        Node temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void removeAt(int position) {
        if (position < 0 || position >= size) {
            return;
        }
        if (head == null) {
            return;
        }
        if (position == 0) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void removeValue(int value) {
        if (head == null) {
            return;
        }
        if (head.value == value) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.value != value) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            size--;
        }
    }

    public int getFirst() {
        if (head == null) {
            return -1;
        }
        return head.value;
    }

    public Node reverse() {
        Node prevNode = null;
        Node currentNode = head;
        Node nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }

    public int getLast() {
        if (head == null) {
            return -1;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.value;
    }

    public int getAt(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public boolean contains(int value) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

}

class Node {
    Node next;
    int value;
    int key;
    Node previous;

    public Node(int value) {
        this.value = value;
    }
}