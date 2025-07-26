public class RemoveKthNodeFromTheEnd {
    public Node removeKthNodeFromTheEnd(Node head, int k) {
        Node leader = head, trailer = head;

        for (int i = 0; i < k; i++) {
            if (leader == null) {
                return head;
            }
            leader = leader.next;
        }
        if (leader == null) {
            return head.next;
        }

        while (leader.next != null) {
            leader = leader.next;
            trailer = trailer.next;
        }
        trailer.next = trailer.next.next;
        return head;
    }

}
