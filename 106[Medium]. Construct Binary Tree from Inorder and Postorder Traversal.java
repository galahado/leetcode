class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, inorder, 0, inorder.length - 1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(Map<Integer, Integer> map, int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight) return null;
        TreeNode node = new TreeNode(postorder[postRight]);
        int index = map.get(node.val);
        int leftLen = (index - 1) - inLeft + 1;
        int postPartition = postLeft + leftLen - 1;
        node.left = helper(map, inorder, inLeft, index-1, postorder, postLeft, postPartition);
        node.right = helper(map, inorder, index + 1, inRight, postorder, postPartition + 1, postRight - 1);
        return node;
    }
}