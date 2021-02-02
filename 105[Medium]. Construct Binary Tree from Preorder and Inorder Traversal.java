class Solution {
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (inLeft > inRight)
            return null;
        TreeNode node = new TreeNode(preorder[preLeft]);
        int index = map.get(node.val);
        int leftLen = (index - 1) - inLeft + 1;
        int preIndex = (preLeft + 1) + leftLen - 1;
        node.left = helper(preorder, preLeft + 1, preIndex, inorder, inLeft, index - 1);
        node.right = helper(preorder, preIndex + 1, preRight, inorder, index + 1, inRight);
        return node;
    }
}