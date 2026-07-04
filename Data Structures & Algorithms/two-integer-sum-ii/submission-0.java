// bruteforce: Try all pairs to find target sum, O(N^2) time
// solution: Use two pointers moving inward from ends on the sorted array to find target sum, O(N) time / O(1) space
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int l = 0, r = numbers.length-1; l < r;) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{l+1, r+1};
            }
        }
        return new int[]{};
    }
}
