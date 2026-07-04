class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        if(q.isEmpty()) return;

        int[][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};

        while(!q.isEmpty()){
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                if(r < 0 || r >= rows || c < 0 || c >=cols || grid[r][c]!= Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[]{r,c});
                grid[r][c] = grid[row][col]+1; 
            } 
        }
    }
}
