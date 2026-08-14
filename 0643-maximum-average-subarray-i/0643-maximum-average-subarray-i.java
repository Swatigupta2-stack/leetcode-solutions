class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = -Double.MAX_VALUE;
        int left = 0;
        double sum=0;
        

        for(int right =0; right<nums.length; right++){
            sum += nums[right];
            if(right-left+1==k){
            double n= sum/k;
            
              max= Math.max(max, n);
              
              sum -= nums[left];
              left++;
            }
        }
        System.out.println(max);
        double ans = max;
        return ans;
    }
}