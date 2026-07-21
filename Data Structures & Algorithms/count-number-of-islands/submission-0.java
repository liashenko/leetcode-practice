class Solution {
    int[][] dirs = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return islands;
    }
    void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int[] dir : dirs) {
            int y = r + dir[0];
            int x = c + dir[1];
            if (y >= 0 && y < visited.length && x >= 0 && x < visited[0].length && grid[y][x] == '1' && !visited[y][x]) {
                dfs(grid, visited, y, x);
            }
        }
    }
}
