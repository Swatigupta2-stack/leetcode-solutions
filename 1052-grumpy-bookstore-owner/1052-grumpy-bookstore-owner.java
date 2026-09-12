class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int happy = 0;

        // Customers who are already satisfied
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                happy += customers[i];
            }
        }

        // First window
        int extra = 0;

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
        }

        int maxExtra = extra;

        // Slide the window
        for (int right = minutes; right < customers.length; right++) {

            // Add new element
            if (grumpy[right] == 1) {
                extra += customers[right];
            }

            // Remove old element
            int left = right - minutes;

            if (grumpy[left] == 1) {
                extra -= customers[left];
            }

            maxExtra = Math.max(maxExtra, extra);
        }

        return happy + maxExtra;
    }
}