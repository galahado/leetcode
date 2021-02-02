class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        if (root.left != null) {
            last(root.left).right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    
    private TreeNode last(TreeNode node) {
        if (node == null) return null;
        TreeNode curr = node;
        while (curr.right != null) curr = curr.right;
        return curr;
    }
}