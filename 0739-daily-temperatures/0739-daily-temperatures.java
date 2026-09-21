class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(!st.isEmpty()) 
            ans[i] = st.peek() - i;//note 

            st.push(i);
        }
         return ans;
    }
}
// initially, the ans is [0,0,0,0,0,0,0,0] so for i 7 and 6 when stack is empty, values bu dflt r 0
