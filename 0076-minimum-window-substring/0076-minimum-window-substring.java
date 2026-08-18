class Solution {
    public String minWindow(String s, String t) {
       
    if (s == null || t == null || s.length() < t.length()) return "";
    
    Map<Character, Integer> map = new HashMap<>();
    Map<Character, Integer> windowMap = new HashMap<>();
    
    // Count characters in t
    for (char c : t.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    
    int left = 0, right = 0;
    int minLen = Integer.MAX_VALUE;
    int minStart = 0;
    int required = map.size(); // number of unique chars needed
    int formed = 0; // number of chars that have met required count
    
    while (right < s.length()) {
        char c = s.charAt(right);
        windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        
        // Check if this character completes the requirement
        if (map.containsKey(c) && windowMap.get(c).intValue() == map.get(c).intValue()) {
            formed++;
        }
        
        // Try to shrink the window
        while (left <= right && formed == required) {
            // Update minimum window
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minStart = left;
            }
            
            // Remove left character from window
            char leftChar = s.charAt(left);
            windowMap.put(leftChar, windowMap.get(leftChar) - 1);
            
            if (map.containsKey(leftChar) && windowMap.get(leftChar) < map.get(leftChar)) {
                formed--;
            }
            left++;
        }
        right++;
    }
    
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
}
        
    }
