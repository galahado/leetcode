// use hashmap and sliding window
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while (map.size() > k) {
                c = s.charAt(start);
                int count = map.get(s.charAt(start));
                if (count == 1) map.remove(c);
                else map.put(c, count - 1);
                start++;
            }
            
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
}
