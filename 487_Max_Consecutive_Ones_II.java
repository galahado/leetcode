// when encountering 0, set prev = curr, let curr start over
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        int prev = 0;
        
        for (int n : nums) {
            curr++;
            if (n == 0) {
                prev = curr;
                curr = 0;
            }
            max = Math.max(max, curr + prev);
        }
        
        return max;
    }
}
