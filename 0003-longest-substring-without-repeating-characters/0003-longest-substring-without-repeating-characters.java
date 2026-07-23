class Solution {
    public int lengthOfLongestSubstring(String s) {
      
    LinkedHashSet<Character> set = new LinkedHashSet<>();
    int max = 0;
    int left = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        
        if (set.contains(ch)) {
            // Remove from left until duplicate is removed
            Iterator<Character> iterator = set.iterator();
            while (iterator.hasNext()) {
                char rm = iterator.next();
                iterator.remove();
                if (rm == ch) break;
            }
        }
        
        set.add(ch);
        max = Math.max(max, set.size());
    }
    
    return max;

    }
}