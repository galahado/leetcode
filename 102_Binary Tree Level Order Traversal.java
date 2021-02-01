// iteration using 2 List for up and down levels
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        List<TreeNode> up = new ArrayList<>();
        List<TreeNode> down = new ArrayList<>();
        up.add(root);
        while (!up.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : up) {
                list.add(node.val);
                if (node.left != null)
                    down.add(node.left);
                if (node.right != null)
                    down.add(node.right);
            }
            result.add(list);
            up = down;
            down = new ArrayList<>();
        }

        return result;
    }
}

// recursion
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            List<List<Integer>> list = new LinkedList<>();
            return list;
        }
        List<TreeNode> level = new LinkedList<>();
        level.add(root);
        return helper(level);
    }

    private List<List<Integer>> helper(List<TreeNode> nodes) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        List<TreeNode> nextLevel = new LinkedList<>();
        for (TreeNode node : nodes) {
            list.add(node.val);
            if (node.left != null)
                nextLevel.add(node.left);
            if (node.right != null)
                nextLevel.add(node.right);
        }
        result.add(list);
        if (nextLevel.size() > 0)
            result.addAll(helper(nextLevel));
        return result;
    }
}

// with BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            result.add(list);
        }

        return result;
    }
}