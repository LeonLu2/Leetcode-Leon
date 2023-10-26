class Solution {
    int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        for(int[] dir : direction){
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') continue;
            dfs(grid, x, y);
        }
    }
}
