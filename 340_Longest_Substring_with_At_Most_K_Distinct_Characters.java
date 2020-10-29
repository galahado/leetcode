// use hashmap and sliding window
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.keySet().contains(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            
            int size = map.keySet().size();
            if (size <= k) max = Math.max(max, end - start + 1);
            else {
                while (size > k) {
                    c = s.charAt(start);
                    if (map.get(c) == 1) {
                        map.remove(c);
                        size--;
                    }
                    else {
                        map.put(c, map.get(c) - 1);
                    }
                    start++;
                }
            }
        }
        
        return max;
    }
}
