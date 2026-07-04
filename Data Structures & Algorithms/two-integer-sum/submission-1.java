// bruteforce: Loop through each element and check if any other element sums to target, O(N^2) time
// solution: Build index map first, then lookup target complement for each index, O(N) time / O(N) space
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i< nums.length; ++i) {
            int j = map.getOrDefault(target-nums[i], -1);
            if (j >= 0 && i != j) {
                return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
