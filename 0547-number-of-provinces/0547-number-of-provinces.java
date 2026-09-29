class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i=0; i< n; i++){
            if(!visited[i]){
                provinces++;
                dfs(i, isConnected, visited);
            }
        }
        return provinces;
        
    }

    void dfs(int city, int[][] isConnected, boolean[] visited){
            visited[city] = true;
             int n = isConnected.length;
            
            for(int j=0; j<n; j++){
                if(isConnected[j][city] ==1 && !visited[j]){
                    dfs(j, isConnected, visited);
                }
            }

        }
}