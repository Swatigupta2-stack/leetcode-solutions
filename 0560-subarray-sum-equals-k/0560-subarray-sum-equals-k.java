class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0,1);
       int prefix=0;
       int count =0;
       for(int num: nums){
        prefix +=num;
        int needed = prefix-k;
        count += map.getOrDefault(needed,0);
        map.put(prefix, map.getOrDefault(prefix,0)+1);
       }
       return count;
    }
}

      