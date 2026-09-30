class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count =0;
        boolean[][] visited = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
            if(grid[i][j]=='1' && !visited[i][j]){
            count++;
            dfs(i, j, grid, visited);
            
            }
        }
        }
        return count;
    }

    void dfs(int nr, int nc, char[][] grid, boolean[][] visited){
         int row = grid.length;
        int col = grid[0].length;
        visited[nr][nc]= true;
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int k = 0; k < 4; k++) {
            int newRow = nr + directions[k][0];
            int newCol = nc + directions[k][1];

            if (newRow >= 0 && newRow < row &&
                newCol >= 0 && newCol < col &&
                grid[newRow][newCol] == '1' &&
                !visited[newRow][newCol]) {

                dfs(newRow, newCol, grid, visited);
              }

      }
    }
}