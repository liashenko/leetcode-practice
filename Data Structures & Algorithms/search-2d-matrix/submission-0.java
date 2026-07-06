// bruteforce: Flatten matrix and linear scan all elements, O(N*M) time
// solution: Treat the matrix as a flattened 1D sorted array, binary search using row = mid/m, col = mid%m, O(log(N*M)) time / O(1) space
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r = n*m-1;
        while (l <= r) {
            int mid = l+(r-l)/2;
            int row = mid/m;
            int col = mid%m;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return false;
    }
}
