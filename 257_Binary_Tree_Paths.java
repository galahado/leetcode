 class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<TreeNode> curr = new LinkedList<>();
        if (root != null) findPath(res, curr, root);
        return res;
    }
    
    public void findPath(List<String> res, List<TreeNode> curr, TreeNode node) {
        curr.add(node);
        if (node.left == null && node.right == null) {
            res.add(transfer(curr));
            return;
        } 
        if (node.left != null) {
            findPath(res, curr, node.left);
            curr.remove(curr.size() - 1);
        }
        if (node.right != null) {
            findPath(res, curr, node.right);
            curr.remove(curr.size() - 1);
        }
        
    }
    
    private String transfer(List<TreeNode> curr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < curr.size() - 1; i++) {
            sb.append(curr.get(i).val);
            sb.append("->");
        }
        sb.append(curr.get(curr.size() - 1).val);
        return sb.toString();
    }
}
