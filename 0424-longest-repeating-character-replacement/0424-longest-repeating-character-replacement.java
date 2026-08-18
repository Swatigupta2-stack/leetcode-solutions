class Solution {
    public int characterReplacement(String s, int k) {
      
    Map<Character, Integer> freq = new HashMap<>();
    int left = 0;
    int maxFreq = 0;
    int maxLength = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        freq.put(c, freq.getOrDefault(c, 0) + 1);
        maxFreq = Math.max(maxFreq, freq.get(c));
        
        int windowSize = right - left + 1;
        if (windowSize - maxFreq > k) {
            char leftChar = s.charAt(left);
            freq.put(leftChar, freq.get(leftChar) - 1);
            left++;
            // Note: maxFreq might not be accurate after shrinking,
            // but it's okay because we only care if it's too large
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
}
}