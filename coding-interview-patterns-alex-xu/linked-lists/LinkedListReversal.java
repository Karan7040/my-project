public class LinkedListReversal {
    public Node reverse(Node head) {
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

    public Node reverseUsingRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newNode = reverseUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
