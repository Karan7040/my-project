public class MaxSumInBTPath {

    public int maxSumFromPath(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        return maxGain(root, maxSum);
    }

    private int maxGain(TreeNode node, int maxSum) {
        if (node == null) {
            return 0;
        }
        int right = maxGain(node.right, maxSum);
        int left = maxGain(node.left, maxSum);
        int localMax = node.val + right + left;
        maxSum = Math.max(localMax, maxSum);
        return 0;
    }
}
