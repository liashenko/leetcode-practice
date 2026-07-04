// bruteforce: Validate each cell iteratively by checking entire row, column, and subgrid, O(N^3) time
// solution: Check Sudoku validity in a single pass using integer bitmasks for row, column, and subgrid tracking, O(1) time / O(1) space
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] sq = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '0' - 1;
                int mask = 1 << val;
                int square = (i/3) * 3 + j/3;
                if ((rows[i] & mask) > 0 || (cols[j] & mask) > 0 || (sq[square] & mask) > 0) {
                    return false;
                }
                rows[i] |= mask;
                cols[j] |= mask;
                sq[square] |= mask;
            }
        }
        return true;
    }
}
