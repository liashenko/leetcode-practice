class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // brute force
        // try each cell and see if water can flow from it to pacific to atlantic
        // O(N^4)
        // optimization 1
        // run from pacific cells -> save visited to pacific
        // run from atlantic cells -> save visited to atlantic
        // cell both in pacific and atlantic is correct
        // O(n*m)
        int n = heights.length;
        int m = heights[0].length;
        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, m-1);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, 0, i);
            dfs(heights, atlantic, n-1, i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; ++j) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    int[][] dirs = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    void dfs(int[][] heights, int[][] visited, int row, int col) {
      if (visited[row][col]==1) return;
      visited[row][col] = 1;
      for (int[] dir : dirs) {
        int nRow = row + dir[0];
        int nCol = col + dir[1];
        if (isValid(heights, nRow, nCol) && heights[row][col] <= heights[nRow][nCol]) {
            dfs(heights, visited, nRow, nCol);
        }
      }
    }

    boolean isValid(int[][] heights, int row, int col) {
        return !(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length);
    }
}
