class Solution {
    public int maxArea(int[] heights) {
        // [1,7,2,5,4,7,3,6]
        // 1 -> 6
        // 1 * 7
        // 6 * 6
        int l = 0, r = heights.length - 1;
        int area = 0;
        while(l < r) {
            area = Math.max(area, Math.min(heights[l], heights[r]) * (r-l));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }
}
