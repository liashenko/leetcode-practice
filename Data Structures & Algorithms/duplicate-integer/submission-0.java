// bruteforce: Compare each element with every other element to find duplicates, O(N^2) time
// solution: Use a HashSet to track seen integers, returning true on first duplicate, O(N) time / O(N) space
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}