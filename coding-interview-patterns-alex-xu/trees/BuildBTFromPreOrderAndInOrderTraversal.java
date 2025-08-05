import java.util.HashMap;
import java.util.Map;

public class BuildBTFromPreOrderAndInOrderTraversal {
    Map<Integer, Integer> inorderAsMap = new HashMap<>();
    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < preorder.length; i++) {
            inorderAsMap.put(preorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);

    }

    public TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preOrderIndex++];
        TreeNode node = new TreeNode(rootValue);
        Integer index = inorderAsMap.get(rootValue);
        node.left = build(preorder, inStart, index - 1);
        node.right = build(preorder, inEnd, index + 1);
        return node;

    }
}
