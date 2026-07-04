// bruteforce: Check all triplets using three nested loops, O(N^3) time
// solution: Sort the array and for each element use two pointers to find pairs that sum to the complement, O(N^2) time / O(N) space
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // map - O(N) space
        // find -(n[i]+n[j])
        // o(1) space
        // two pointers 
        // fix i, go with two pointers to find -nums[i]
        // -4 -1 -1 0 1 2
        // -1 
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
        for (int l = i+1, r = nums.length-1; l<r;) {
            if (nums[i] + nums[l] + nums[r] == 0) {
                res.add(List.of(nums[i], nums[l], nums[r]));
                l++;
                r--;
            } else if (nums[l] + nums[r] > -nums[i]) {
                r--;
            } else {
                l++;
            }
        }
        }
        return new ArrayList<>(res);
    }
}
