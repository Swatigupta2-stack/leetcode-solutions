class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int first =-1, last =-1;
        int left = 0;
        int right = nums.length-1;
        /*if(nums.length==1 && target!=nums[0]){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }*/
        while(left<=right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target)
            {   
                 first = mid;
                right= mid-1;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else{ right = mid-1;}
        }

       left=0;
       right = nums.length-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(nums[mid]==target)
            {   
                 last = mid;
                left= mid+1;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else{ right = mid-1;}
        }
        ans[0] =first;
        ans[1]= last;
       
        return ans;

    }
}