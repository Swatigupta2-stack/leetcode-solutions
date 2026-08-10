class Solution {
    public int findNumbers(int[] nums) {
        
        int ans=0;
       for(int i=0; i<nums.length; i++){
        int n= nums[i];
        int count=0;
        if(n==0) count++;
        while(n!=0){
            n=n/10;
            count++;
        }
        if(count %2==0) ans++;
       }
       return ans; 
    }
}