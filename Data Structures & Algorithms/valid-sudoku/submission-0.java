class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        for (int i = 0; i < n; ++i) {
            boolean[] vis = new boolean[n];
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') continue;
                int x = board[i][j] - '0' - 1;
                if (vis[x]) {
                    return false;
                }
                vis[x] = true;
            }
        }
        for (int i = 0; i < n; ++i) {
            boolean[] vis = new boolean[n];
            for (int j = 0; j < n; ++j) {
                if (board[j][i] == '.') continue;
                int x = board[j][i] - '0' - 1;
                if (vis[x]) {
                    return false;
                }
                vis[x] = true;
            }
        }
        // 0 0
        // 0 2
        // 2 0
        // 2 2
        
        // 0 3
        // 0 5
        // 2 3
        // 2 5
        for (int a = 0; a < 3; a++) {
        for (int b = 0; b < 3; b++) {
        boolean[] vis = new boolean[n];
        for (int i = 3*a; i < 3 + 3*a; i++) {
            for (int j = 3*b; j < 3 + 3*b; ++j) {
                if (board[i][j] == '.') continue;
                int x = board[i][j] - '0' - 1;
                if (vis[x]) {
                    return false;
                }
                vis[x] = true;
            }
        }
        }
        }
        return true;
    }
}
