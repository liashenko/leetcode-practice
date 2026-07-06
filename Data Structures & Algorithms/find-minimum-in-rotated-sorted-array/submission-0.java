// bruteforce: Scan array linearly tracking the minimum, O(N) time
// solution: Binary search comparing nums[mid] with nums[r] to locate rotation point, O(log N) time / O(1) space
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        // find min
        // if sorted it's just first
        // if rotated, binary search lower bound
        while (l < r) {
            int mid = l + (r-l)/2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
