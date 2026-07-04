class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            Set<Character> rC = rows.getOrDefault(i, new HashSet<>());
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') continue;
                char x = board[i][j];
                if (rC.contains(x)) {
                    return false;
                }
                Set<Character> cC = cols.getOrDefault(j, new HashSet<>());
                if (cC.contains(x)) {
                    return false;
                }
                String key = (i/3) + "," + (j/3);
                Set<Character> sC = squares.getOrDefault(key, new HashSet<>());
                if (sC.contains(x)) {
                    return false;
                }
                rC.add(x);
                cC.add(x);
                sC.add(x);
                rows.put(i, rC);
                cols.put(j, cC);
                squares.put(key, sC);
            }
        }
        return true;
    }
}
