//using sliding window brute force
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            int windowSum = 0;
            for (int j = 0; j < nums.length; j++) {
                windowSum += nums[j];
                if (j >= i - 1) {
                    if (windowSum >= s) return i;
                    windowSum -= nums[j - i + 1];
                }
            }
        }
        
        return 0;
    }
}
