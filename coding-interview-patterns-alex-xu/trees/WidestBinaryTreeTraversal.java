import java.util.LinkedList;
import java.util.Queue;

public class WidestBinaryTreeTraversal {
    public int widestBinaryTreeTraversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        int maxWidth = 0;
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int leftMostIndex = queue.peek().value;
            int rightMostIndex = leftMostIndex;
            for (int i = 0; i < queue.size(); i++) {
                Pair pair = queue.poll();
                int index = pair.value;
                rightMostIndex = index;
                if (pair.node.left != null) {
                    queue.offer(new Pair(pair.node.left, 2 * index + 1));
                }
                if (pair.node.right != null) {
                    queue.offer(new Pair(pair.node.right, 2 * index + 2));
                }
            }
            maxWidth = Math.max(maxWidth, rightMostIndex - leftMostIndex + 1);

        }
        return maxWidth;
    }


}

class Pair {
    TreeNode node;
    int value;

    public Pair(TreeNode node, int value) {
        this.node = node;
        this.value = value;
    }
}
