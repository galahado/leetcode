public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#,";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(',');
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (String s : tree) list.add(s);
        return deHelper(list);
    }
    
    private TreeNode deHelper(LinkedList<String> list) {
        String s = list.getFirst();
        list.removeFirst();
        if (s.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deHelper(list);
        node.right = deHelper(list);
        return node;
    }
}