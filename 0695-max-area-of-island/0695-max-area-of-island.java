class Solution {
   
    public int maxAreaOfIsland(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int max = 0;
        for(int i =0; i< row; i++){
            for(int j=0; j< col; j++){
                if(!visited[i][j] && grid[i][j]==1){
                
                int area = dfs(i, j, grid, visited);
                max = Math.max(max, area);
                }
            }
        }
        
        return max;
    }

    int dfs(int r, int c, int[][] grid, boolean[][] visited){
     int row = grid.length;
        int col = grid[0].length;
        visited[r][c] = true;
        int area= 1;
        int[][] dir = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        for(int k =0; k< 4; k++){
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];
            
            if(nr>=0 && nr< row && nc>=0 && nc<col && !visited[nr][nc] && grid[nr][nc]==1){
                           
               area += dfs(nr, nc,grid, visited);
                
            }
        }
        return area;

    }
}