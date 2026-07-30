class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int longest = 0;

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) { ///key+1 is notteh next key just key greater than current key by 1
                longest = Math.max(longest,
                        map.get(key) + map.get(key + 1));
            }
        }

        return longest;
      

    }
}