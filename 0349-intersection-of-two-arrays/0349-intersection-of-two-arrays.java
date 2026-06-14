class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      HashSet<Integer> set1 = new HashSet<>();
      HashSet<Integer> set2 = new HashSet<>();
       for(int n : nums1){
        set1.add(n);
       } 
       for(int n : nums2){
        set2.add(n);
       }
       HashSet set11= new HashSet<>();
       for(int n : nums1){
        set11.add(n);
       }
        set11.removeAll(set2);
      
       
       set1.removeAll(set11);
       
       int[] result = new int[set1.size()];
       int i=0;
       for(int n : set1){
        result[i++] = n;
       }
       return result;
    }
}