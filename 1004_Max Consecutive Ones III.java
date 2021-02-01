// using sliding window
class Solution {
    public int longestOnes(int[] A, int K) {
        int start = 0;
        int max = 0;
        int zeros = 0;
        
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) zeros++;
            
            while (zeros > K) {
                if (A[start] == 0) zeros--;
                start++;
            }
            
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
}
