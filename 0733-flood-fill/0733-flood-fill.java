class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     Queue<int[]> q = new ArrayDeque<>();
     int rows = image.length;
     int cols = image[0].length;
     boolean[][] visited = new boolean[rows][cols];
     int[][] directions = {
        {-1,0},
        {1,0},
        {0,-1},
        {0,1}
     };
     q.offer(new int[] {sr,sc});
     int find = image[sr][sc];
     image[sr][sc] = color;
     visited[sr][sc] = true;
     while(!q.isEmpty()){
        int[] cell = q.poll();
        int r = cell[0];
        int c = cell[1];

        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
             
             if(nr>=0 && nr< rows && nc>=0 && nc< cols && !visited[nr][nc] && image[nr][nc]==find){
                visited[nr][nc] = true;
                q.offer(new int[] {nr,nc});
                image[nr][nc] = color;
                
                
             }
        }
       
     }
      return image;   
    }
}