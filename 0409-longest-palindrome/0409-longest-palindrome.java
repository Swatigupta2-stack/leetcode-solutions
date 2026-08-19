class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

       int count=0, n=0;
        for(int value: map.values()){
            if(value%2==0)
            count += value;    
            else if(value %2==1 && value>2)
            {  if(n<1)
                n++;
                count += value-1;
                
            }
            else if(value==1){
                if(n<1)
                n++;
            }
        }
        count =count+n;
        return count;

    }
}