class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       
    int count = 0;
    long prefixSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    
    for (int num : nums) {
        prefixSum += num;
        int mod = (int)(prefixSum % k);
        if (mod < 0) mod += k;  // Handle negative modulo in Java
        count += map.getOrDefault(mod, 0);
        map.put(mod, map.getOrDefault(mod, 0) + 1);
    }
    return count;

    }
}