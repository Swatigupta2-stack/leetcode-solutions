class Solution {
    void solve(int[] nums, List<List<Integer>> res, List<Integer> ds, boolean[] mp)
    {
        if(ds.size() ==nums.length)
        {

            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i< nums.length; i++)
        {
          if(!mp[i])
          {
          ds.add(nums[i]);
          mp[i] = true;
          solve(nums, res, ds, mp);
          mp[i]= false;
          ds.remove(ds.size() - 1);
          }
        }
    }
     public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] mp = new boolean[nums.length];
        solve(nums, res, new ArrayList<>(), mp);
        return res;
     }
}
