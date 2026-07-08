class Solution {
    public int findDuplicate(int[] nums) {
        int res = 0;
        for (int bit = 0; bit < 32; ++bit) {
            int mask = 1 << bit;
            int cnt = 0;
            for (int x : nums) {
                cnt += (x & mask) > 0 ? 1 : 0;
            }
            int expected = 0;
            for (int j = 1; j < nums.length; ++j) {
                expected += (j & mask) > 0 ? 1 : 0;
            }
            if (cnt > expected) {
                res |= mask;
            }
        }
        return res;
    }
}
