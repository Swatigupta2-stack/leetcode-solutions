class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sm =new HashMap<>();
        Map<Character, Integer> tm= new HashMap<>();
        Map<Character, Character> map = new HashMap<>();
         if(s.length() !=t.length())
         return false;
         //int i = 0;
        /* while(i<s.length()){
            char c = s.charAt(i);
            char d = t.charAt(i);
            if(sm.containsKey(c)){
                if(tm.containsKey(d)){
                    sm.put(c, sm.get(c)+1);
                    tm.put(d, tm.get(d)+1);
                }
                else
                return false;
            }
            if(tm.containsKey(d)){
               if(sm.containsKey(c)){
                sm.put(c, sm.get(c)+1);
                tm.put(d, tm.get(d)+1);
               } 
               else 
               return false;
            }
            else{
            sm.put(c,1);
            tm.put(d,1);}
            i++;
         }
         */
         for(int i =0; i< s.length();i++){
            char c = s.charAt(i);
            char d = t.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c)==d)
                continue;
                else{
                return false;
                }
            }
            if(map.containsValue(d)){
                if(map.containsKey(c))
                
                continue;
                else
                return false;
            }
            else{
            map.put(c,d);
            }
           

         }
         return true;
    }
}