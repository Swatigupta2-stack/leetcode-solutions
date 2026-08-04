class Solution {
    public int orangesRotting(int[][] grid) {
        
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Count fresh oranges and add rotten ones to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If no fresh oranges, return 0
        if (freshCount == 0) return 0;
        
        // Step 2: BFS to rot adjacent oranges
        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            boolean rotted = false;
            
            for (int i = 0; i < size; i++) {           // Loop through ALL rotten oranges at current minute
               int[] curr = queue.poll();              // Get one rotten orange from queue
               int row = curr[0];                      // Its row position
               int col = curr[1];                      // Its column position
    
             for (int[] dir : directions) {          // Check all 4 neighbors of this orange
                  int newRow = row + dir[0];          // Calculate new row
                   int newCol = col + dir[1];          // Calculate new column
        
                  if (newRow >= 0 && newRow < rows &&    // Is new row inside grid?
                            newCol >= 0 && newCol < cols &&    // Is new column inside grid?
                            grid[newRow][newCol] == 1) {       // Is it a fresh orange?
            
                        // If all conditions pass, rot this fresh orange!
                           grid[newRow][newCol] = 2;          // Mark as rotten
                          queue.offer(new int[]{newRow, newCol}); // Add to queue for next minute
                          freshCount--;                      // Decrease fresh count                  
                        rotted = true;
                    }
                }
            }
            
            if (rotted) minutes++;
        }
        
        // Step 3: Check if all oranges are rotten
        return freshCount == 0 ? minutes : -1;
    
    }
    /*{0, 1} → Right (row stays same, column +1)

{0, -1} → Left (row stays same, column -1)

{1, 0} → Down (row +1, column stays same)

{-1, 0} → Up (row -1, column stays same)
*/

}