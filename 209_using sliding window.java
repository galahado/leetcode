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


// better window sliding solution
// https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int windowStart = 0;
        int windowEnd = 0;
        int windowSum = 0;
        int min = nums.length + 1;
        
        for (; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            
            while (windowSum >= s) {
                min = Math.min(min, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        
        if (min == nums.length + 1) min = 0;
        return min;
    }
}
