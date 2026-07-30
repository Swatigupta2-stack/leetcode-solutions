class Solution {
    public String frequencySort(String s) {
       Map<Character, Integer> map = new HashMap<>();

       for(char c : s.toCharArray()){
        map.put(c, map.getOrDefault(c,0)+1);
       } 
       //bucket
       List<Character>[] bucket = new ArrayList[s.length()+1];
      //filling buckets
      for(char key : map.keySet()){
        int freq = map.get(key);
        if(bucket[freq]==null)
        bucket[freq]= new ArrayList<>();

        bucket[freq].add(key);
      }
      char[] res = new char[s.length()];
      int index = 0;
      for(int i = bucket.length -1; i>=0 ; i--){
        if(bucket[i]!=null){
           for(char c: bucket[i]){
            for(int j=0; j< i; j++){
             res[index++] = c;
            }
            }
        }
      }
      String ans = new String(res);
      return ans;
    }
}