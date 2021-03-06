class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwo(root.left, root.right);
        return root;
    }
    
    public void connectTwo(Node n1, Node n2) {
        if (n1 == null || n2 == null) return;
        n1.next = n2;
        connectTwo(n1.left, n1.right);
        connectTwo(n2.left, n2.right);
        connectTwo(n1.right, n2.left);
    }
}