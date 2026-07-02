class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0; i< rows; i++){
            for(int j=0; j<cols; j++){
                int curr = 0;
                curr+=dfs(grid, i, j);
                maxArea = Math.max(curr, maxArea);
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;

        return 1+dfs(grid, row+1, col)
                +dfs(grid, row-1, col)
                +dfs(grid, row, col+1)
                +dfs(grid, row, col-1);
    }
}
