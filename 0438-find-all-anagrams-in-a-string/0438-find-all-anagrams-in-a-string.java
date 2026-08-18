class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       Map<Character, Integer> map = new HashMap<>();
      

       List<Integer> ans = new ArrayList<>();
       for(char c: p.toCharArray()){
        map.put(c, map.getOrDefault(c,0)+1);
       }
        Map<Character,Integer> dmap =  new HashMap<>(map);
       
       
       
       int left =0, n=0;
       int count=0;

       for(int right=0; right<s.length(); right++){
         char c =s.charAt(right);

         if(map.containsKey(c)){
            map.put(c, map.get(c)-1);
            if(map.get(c)>=0)
            count++;
            
         }
         if(right-left+1> p.length()){
            char leftChar = s.charAt(left);
            if(map.containsKey(leftChar)){
                if(map.get(leftChar)>=0){
                    count--;
                }
                map.put(leftChar, map.get(leftChar)+1);
            }
            left++;
         }
         


         if(count==p.length()){
            ans.add(left);
         }

       }
       return ans;

    }
}