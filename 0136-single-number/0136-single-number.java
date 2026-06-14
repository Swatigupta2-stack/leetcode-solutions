class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                set.remove(num);
            }
        }
        
        for(int num: set){
            return num;
        }
        return -1;
    }
}