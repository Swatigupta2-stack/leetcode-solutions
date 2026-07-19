class Solution {
    public int longestConsecutive(int[] nums) {
        int length = 0;
        int current = 0, max=0;
        if(nums.length==0)
        return 0;
        Set<Integer> set = new HashSet<>();
         for(int num : nums){
            set.add(num);
         }
         for(int num : set){
            if(!set.contains(num-1)){
             current = num;
             length = 1;
             while(set.contains(current+1)){
                current++;
                length++;
             }
            }
          max = Math.max(max, length);
         }
         return max;
    }
}