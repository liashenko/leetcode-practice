class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1,2,4,6]
        // 1 1 2 8 48
        // 48 48 24 6 1 - fromRight
        // product = fromLeft-1 * fromRight+1
        int[] fromLeft = new int[nums.length+1];
        fromLeft[0] = 1;
        for (int i = 1; i <= nums.length; ++i) {
            fromLeft[i] = fromLeft[i-1] * nums[i-1];
        }
        int[] fromRight = new int[nums.length+1];
        fromRight[nums.length] = 1;
        for (int i = nums.length-1; i >= 0; --i) {
            fromRight[i] = fromRight[i+1] * nums[i];
        }
        int[] res = new int[nums.length];
        for (int i = 1; i <= nums.length; ++i) {
            res[i-1] = fromLeft[i-1] * fromRight[i];
        }
        return res;
    }
}  
