class Solution {
    int res = Integer.MIN_VALUE;

    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                int size = 0;
                if(grid[i][j] == 1){
                    size = dfs(grid, i, j);
                }
                if(size > res) res = size;
            }
        }
        return res;
    }
    private int dfs(int[][] grid, int i, int j){
        int size = 1;
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int up = dfs(grid, i, j + 1);
        int down = dfs(grid, i, j - 1);
        int left = dfs(grid, i - 1, j);
        int right = dfs(grid, i + 1, j);
        return size + up + down + left + right;
    }
}