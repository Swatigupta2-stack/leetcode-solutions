class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for(String  s : words){
            map.put(s, map.getOrDefault(s,0)+1);
        }
        //bucket
        List<String>[] bucket =new ArrayList[words.length +1];
        //filling bucket
        for(String key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<String> res = new ArrayList<>(k);
        int index = 0;

        for(int i = bucket.length-1; i>=0 && index<k ; i--){
            if(bucket[i]!=null){
                for(String s : bucket[i]){
                res.add(s);
                index++;
                if(index==k) break;
                }
            }
        }
        return res;
    }
}