// bruteforce: Sort array and find the longest consecutive run, O(N log N) time
// solution: Populate a HashSet with integers, then build sequences starting only from sequence boundaries, O(N) time / O(N) space
class Solution {
    public int longestConsecutive(int[] nums) {
        // bruteforce
        // 2, 3, 4, 5
        // 3, 4, 5
        // 4, 5
        // n^2
        // hashset
        // 2, 3, 4, 5
        // start sequence only if n-1 doesn't exist in hashset
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            seen.add(n);
        }
        int longest = 0;
        for (int n : nums) {
            if (!seen.contains(n-1)) {
                int x = n+1;
                while (seen.contains(x)) {
                    x++;
                }
                longest = Math.max(longest, x-n);
            }
        }
        return longest;
    }
}
