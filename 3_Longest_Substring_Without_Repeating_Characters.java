// using sliding window and set
// almost the same as 340_Longest_Substring_with_At_Most_K_Distinct_Characters.java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (set.contains(c)) {
                while (s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                set.add(c);
            }
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
}
