class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
     
     
     List<Integer>[] graph = new ArrayList[n];

     for(int i=0; i<n; i++){
        graph[i] = new ArrayList<>();
     }

     for(int[] edge: edges){
        int u = edge[0];
        int v = edge[1];

        graph[u].add(v);
        graph[v].add(u);
     }

     Queue<Integer> q = new ArrayDeque<>();
     boolean[] visited = new boolean[n];
     int start = source;
     visited[start] = true;
     q.offer(start);
      while(!q.isEmpty()){
        int node = q.poll();
         if(node == destination)
         return true;

        for(int next: graph[node]){
            if(!visited[next]){
                visited[next] = true;
                q.offer(next);
            }
        }
      }
      return false;
    }
}