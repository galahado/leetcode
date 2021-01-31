class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        findPath(res, curr, root, targetSum);
        return res;
    }
    
    private void findPath(List<List<Integer>> res, LinkedList<Integer> curr, TreeNode node, int sum) {
        if (node == null) return;
        curr.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            res.add((List<Integer>)curr.clone());
        }
        else {
            findPath(res, curr, node.left, sum - node.val);
            findPath(res, curr, node.right, sum - node.val);
        }
        curr.removeLast();
    }
}
