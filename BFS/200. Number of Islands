class Solution {
    boolean[][] visited;
    int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(grid, i, j);
                    ++res;
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, int i, int j){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int m = cur[0];
            int n = cur[1];
            for(int q = 0; q < 4; ++q){
                int nextX = m + direction[q][0];
                int nextY = n + direction[q][1];
                if(nextX < 0 || nextY < 0 || nextX == grid.length || nextY == grid[0].length || grid[nextX][nextY] == '0') continue;
                if(!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
            
        }
    }
}
