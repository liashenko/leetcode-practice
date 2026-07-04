// bruteforce: Find left and right maximums on the fly for each position, O(N^2) time
// solution: Precompute right maximums in an array and track left maximum on the fly to calculate trapped water, O(N) time / O(N) space
class Solution {
    public int trap(int[] height) {
        int area = 0;
        // max to left, max to right
        // area+= min(0, min(maxLeft, maxRight) - height[i]);
        int maxLeft = 0;
        int[] maxRight = new int[height.length];
        maxRight[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >=0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }
        for (int i = 0; i < height.length; i++) {
            area+= Math.max(0, Math.min(maxLeft, maxRight[i]) - height[i]);
            maxLeft = Math.max(maxLeft, height[i]);
        }
        return area;
    }
}
