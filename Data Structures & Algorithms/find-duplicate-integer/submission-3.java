class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length-1;
        while (l < r) {
            int mid = l + (r-l)/2;
            int cnt = 0;
            for (int x : nums) {
                if (x <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
