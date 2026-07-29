class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int value = 1;
        if(n==1)
        return nums[0];
        for(int i = 0; i<n ; i++){
           
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i], map.get(nums[i])+1);
                if(map.get(nums[i]) > n/2)
                return nums[i];
            }
            else
             map.put(nums[i],value);
        }
        return 0;
    }
}