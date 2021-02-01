//using sliding window
class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int start = 0;
        int subMax = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            subMax = Math.max(count, subMax);
            
            while (end - start + 1 - subMax > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
}
