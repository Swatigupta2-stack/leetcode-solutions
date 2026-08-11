class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int[] ans = new int[2];
        
        int i=0;
        while(i<nums.length){
            
            int rem = target-nums[i];

            if(map.containsKey(rem))
            {
                int index = map.get(rem);
                ans[0] =i;
                ans[1] = index;
            }
            map.put( nums[i],i);
            i++;
        }
        return ans;
    }
}