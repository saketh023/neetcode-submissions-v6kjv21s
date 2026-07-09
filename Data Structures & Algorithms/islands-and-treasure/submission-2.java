class Solution {
    Queue<int[]> q = new LinkedList<>();
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[] curr = {0,0};
        while(!q.isEmpty()){
            curr = q.poll();
            bfs(curr, grid, grid[curr[0]][curr[1]]);
        }
    }

    private void bfs(int[] pos, int[][] grid, int dist){
        int row = pos[0];
        int col = pos[1];

        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1){
                continue;
            }
            if(grid[r][c] == Integer.MAX_VALUE || grid[r][c] > dist+1){
                grid[r][c] = dist+1;
                q.offer(new int[]{r,c});
            }
        }
    }
}
