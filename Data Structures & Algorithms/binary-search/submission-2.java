// bruteforce: Scan the array linearly from left to right to find the target element, O(N) time
// solution: Use standard binary search by checking the middle element and narrowing the search space by half in each step, O(log N) time / O(1) space
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = l+(r-l)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}
