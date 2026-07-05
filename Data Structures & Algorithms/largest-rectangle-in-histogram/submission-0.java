class Solution {
    public int largestRectangleArea(int[] heights) {
        // idea
        // increasing stack
        int largest = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= heights.length; ++i) {
            // if the current is shorter, check what rectangle we can form
            while (!st.isEmpty() && (i == heights.length || heights[i] < heights[st.peek()])) {
                int top = st.pop();
                int height = heights[top];
                // bounded by the current idx exclusively
                int right = i;
                // if empty, we can go all the way to the beginning
                int left = st.isEmpty() ? -1 : st.peek();
                // if not, we are bounded by the first shorter bar on the left
                int width = right - left - 1;
                largest = Math.max(largest, height*width);
            }
            st.push(i);
        }   
        return largest;
    }
}
