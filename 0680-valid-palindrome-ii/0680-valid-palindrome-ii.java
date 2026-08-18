class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
int right = s.length() - 1;
int ignore = 0;

while (left <= right) {
    char x = s.charAt(left);
    char y = s.charAt(right);

    if (x != y && ignore == 0) {
        // Try skipping left first
        if (s.charAt(left + 1) == s.charAt(right)) {
            // But we need to verify skipping left actually works for the rest
            int tempLeft = left + 1;
            int tempRight = right;
            boolean skipLeftWorks = true;
            
            while (tempLeft < tempRight) {
                if (s.charAt(tempLeft) != s.charAt(tempRight)) {
                    skipLeftWorks = false;
                    break;
                }
                tempLeft++;
                tempRight--;
            }
            
            // Try skipping right
            tempLeft = left;
            tempRight = right - 1;
            boolean skipRightWorks = true;
            
            while (tempLeft < tempRight) {
                if (s.charAt(tempLeft) != s.charAt(tempRight)) {
                    skipRightWorks = false;
                    break;
                }
                tempLeft++;
                tempRight--;
            }
            
            // If either works, return true
            if (skipLeftWorks || skipRightWorks) {
                return true;
            } else {
                return false;
            }
        } 
        else if (s.charAt(right - 1) == s.charAt(left)) {
            // Try skipping right
            int tempLeft = left;
            int tempRight = right - 1;
            
            while (tempLeft < tempRight) {
                if (s.charAt(tempLeft) != s.charAt(tempRight)) {
                    return false;
                }
                tempLeft++;
                tempRight--;
            }
            return true;
        } 
        else {
            return false;
        }
    } 
    else if (x != y && ignore == 1) {
        return false;
    } 
    else {
        left++;
        right--;
    }
}
return true;
    }
}