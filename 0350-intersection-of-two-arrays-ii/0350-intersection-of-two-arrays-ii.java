class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int n: nums1){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for(int i=0; i< nums2.length; i++){
            if(map.containsKey(nums2[i])){
                ans.add(nums2[i]);
                if(map.get(nums2[i])==1){
                map.remove(nums2[i]);
                }
                if(map.containsKey(nums2[i]))
                map.put(nums2[i], map.getOrDefault(nums2[i],0)-1);

                
                
            }
        }
        int[] arr = ans.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}