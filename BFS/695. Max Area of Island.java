class Solution {
    int[][] dir = {{1,0}, {0,1}, {-1,0},{0,-1}};
    int res = Integer.MIN_VALUE;

    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                int size = 0;
                if(grid[i][j] == 1){
                    size = bfs(grid, i, j);
                }
                if(size > res) res = size;
            }
        }
        return res;
    }
    
    private int bfs(int[][] grid, int i, int j){
        int size = 1;
        grid[i][j] = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int nextX = cur[0];
            int nextY = cur[1];
            for(int q = 0; q < 4; ++q){
                int m = nextX + dir[q][0];
                int n = nextY + dir[q][1];
                if(m < 0 || n < 0 || m == grid.length || n == grid[0].length || grid[m][n] == 0) continue;
                ++size;
                queue.offer(new int[]{m, n});
                grid[m][n] = 0;
            }
        }
        return size;
    }
}