class Solution {
    public String removeDuplicates(String s) {
       /*StringBuilder sd = new StringBuilder();
       for(int i=0; i< s.length(); i++){
        
        if((i-1)!= -1){
        if(s.charAt(i) == s.charAt(i-1) )
        sd.deleteCharAt(i-1);
        continue;
        }
        
        sd.append(s.charAt(i));
       } 
       return sd.toString();
       */
       StringBuilder sd = new StringBuilder();
       Stack<Character> st= new Stack<>();
       for(int i=0; i< s.length(); i++){
        
        
            if(!st.isEmpty() && s.charAt(i)== st.peek()){
            st.pop();
            continue;
            }
        
        
            st.push(s.charAt(i));
        
        
       }
       
       for(char c: st){
        sd.append(c);
       }
       return sd.toString();
    }
}