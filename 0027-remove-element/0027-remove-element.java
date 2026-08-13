class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0;
        int r= 1;
        int pos=0;
        while(l<nums.length){
            if(nums[l]!=val){
           int temp = nums[pos];
                nums[pos] = nums[l];
                nums[l] = temp;
                pos++;
            }
            l++;
            

        }
        return pos;
    }
}