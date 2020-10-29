// using hashmap and sliding window
// almost the same as 340_Longest_Substring_with_At_Most_K_Distinct_Characters.java
class Solution {
    private static final int BASKETS = 2;
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        
        for (int end = 0; end < tree.length; end++) {
            map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);
            
            while (map.size() > Solution.BASKETS) {
                map.put(tree[start], map.get(tree[start]) - 1);
                if (map.get(tree[start]) == 0) map.remove(tree[start]);
                start++;
            }
            
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
}
