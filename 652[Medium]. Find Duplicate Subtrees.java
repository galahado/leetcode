class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new LinkedList<>();
        findDuplicate(map, list, root);
        return list;
    }
    
    private void findDuplicate(Map<String, Integer> map, List<TreeNode> list, TreeNode node) {
        if (node == null) return;
        String s = serialize(node);
        if (map.containsKey(s)) {
            if (map.get(s) == 0) {
                list.add(node);
                map.put(s, 1);
            }
        } else {
            map.put(s, 0);
        }
        findDuplicate(map, list, node.left);
        findDuplicate(map, list, node.right);
    }
    
    public String serialize(TreeNode root) {
    if (root == null) return "#,";
    StringBuilder sb = new StringBuilder();
    sb.append(root.val).append(',');
    sb.append(serialize(root.left));
    sb.append(serialize(root.right));
    return sb.toString();
    }
}