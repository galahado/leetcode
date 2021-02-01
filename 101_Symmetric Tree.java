// recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        else if (!(left.val == right.val)) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}


// iteration
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null || root.right == null) return root.left == root.right;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1.val != n2.val) return false;
            if (n1.left != null && n2.right != null) {
                queue.offer(n1.left);
                queue.offer(n2.right);
            } else if (n1.left != n2.right) {
                return false;
            }
            if (n1.right != null && n2.left != null) {
                queue.offer(n1.right);
                queue.offer(n2.left);
            } else if (n1.right != n2.left) {
                return false;
            }
        }
        
        return true;
    }
}
