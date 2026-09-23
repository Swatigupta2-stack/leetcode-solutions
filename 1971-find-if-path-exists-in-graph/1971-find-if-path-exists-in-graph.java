class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
     
     //Create graph
     List<Integer>[] graph = new ArrayList[n];
     //initialize every list
     for(int i=0; i<n; i++){
        graph[i] = new ArrayList<>();
     }
      //add edges to graph
     for(int[] edge: edges){
        int u = edge[0];
        int v = edge[1];

        graph[u].add(v);
        graph[v].add(u);
        //Why both?
     //Because this is an undirected graph.
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
/*
edges = [[0,1], [0,2], [1,2]]

This means:

0 ─── 1
 \   /
   2

   Each edges[i] contains two connected nodes:

edges[i][0]
edges[i][1]

So we create:

List<Integer>[] graph = new ArrayList[n];

Then initialize each list
Then graph[node] works

Suppose:

graph[0] = [1, 2]
graph[1] = [0, 2]
graph[2] = [0, 1]
*/