 class Solution {
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        int[] curr = new int[1];
        if (root != null) sumTree(sum, curr, root);
        return sum[0];
    }
    
    private void sumTree(int[] sum, int[] curr, TreeNode node) {
        curr[0] = curr[0] * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum[0] += curr[0];
            return;
        }
        
        if (node.left != null) {
            sumTree(sum, curr, node.left);
            curr[0] /= 10;
        }
        
        if (node.right != null) {
            sumTree(sum, curr, node.right);
            curr[0] /= 10;
        }
    }
}
