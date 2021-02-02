class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        return maxTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode maxTree(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        int index = maxIndex(nums, left, right);
        TreeNode node = new TreeNode(nums[index]);
        node.left = maxTree(nums, left, index - 1);
        node.right = maxTree(nums, index + 1, right);
        return node;
    }
    
    private int maxIndex(int[] nums, int left, int right) {
        int res = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[res]) res = i;
        }
        
        return res;
    }
}