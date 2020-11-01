// iteration
// a node is visited only when it is popped from the stack and it has no right child in the stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                if (curr.right != null) stack.push(curr.right);
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (!stack.isEmpty() && curr.right == stack.peek()) {
                    TreeNode temp = curr;
                    curr = stack.pop();
                    stack.push(temp);
                } else {
                    result.add(curr.val);
                    curr = null;
                }
            }
        }
        
        return result;
    }
}
