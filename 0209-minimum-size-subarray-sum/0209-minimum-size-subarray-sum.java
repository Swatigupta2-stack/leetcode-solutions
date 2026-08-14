class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int count =0;
       int sum =0;
       int totalsum=0;
       int left=0;
       int min = Integer.MAX_VALUE;
       
       for(int i=0; i<nums.length; i++){
        sum += nums[i];
        totalsum += nums[i];
        count++;
        if(totalsum<target && i==nums.length-1)
        return 0;
        if(sum>= target){
            min= Math.min(min, count);   
           }
         while(sum>target){
            sum -= nums[left];
            count--;
            if(sum>= target){
            min= Math.min(min, count);
            }
            if(sum<target){
                //sum=0;
                //count=0;
                
            }
            
            left++;

        }
        
        
        
       } 
       return min;
    }
}