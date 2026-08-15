class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left <= right) {  //here left ans right give the range for hours need, not indices

            int mid = left + (right - left) / 2;

            long hours = 0;

            for(int pile : piles) {
                hours += (pile + mid - 1) / mid;   //at this mid from the range[left, right], what is the possible hour(k) that could come..
            }

            if(hours <= h) {  //if hours<h , then our range[L,R] should be BEFORE the mid of current [L,R]
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}