class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int g=0;
        List<Boolean> res = new ArrayList<>();
        for(int n: candies){
            g= Math.max(g,n);
        }
        for(int i: candies){
           res.add(i+ extraCandies >= g);
           }

          return res; 
    }
}