class Solution {
    public int trap(int[] height) {
        int area = 0;
        // max to left, max to right
        // area+= min(0, min(maxLeft, maxRight) - height[i]);
        int maxLeft = 0;
        int maxRight = 0;
        for (int l = 0, r = height.length-1; l<r;) {
            maxLeft = Math.max(maxLeft, height[l]);
            maxRight= Math.max(maxRight, height[r]);
            if (height[l] < height[r]) {
                area+= Math.max(0, Math.min(maxLeft, maxRight) - height[l]);
                l++;
            } else {
                area+= Math.max(0, Math.min(maxLeft, maxRight) - height[r]);
                r--;
            }
        }
        return area;
    }
}
