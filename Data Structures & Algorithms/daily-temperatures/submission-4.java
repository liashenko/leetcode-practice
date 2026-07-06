// bruteforce: For each day, scan forward to find the next warmer day, O(N^2) time
// solution: Use a monotonic decreasing stack storing indices to find the next warmer day in a single pass, O(N) time / O(N) space
class Solution {
    public int[] dailyTemperatures(int[] t) {
        // bruteforce: just find next largest value O(N^2)
        // optimization: stack
        Stack<Integer> st = new Stack<>();
        int[] res = new int[t.length];
        for (int i = 0; i < t.length; ++i) {
            while (!st.isEmpty() && t[i] > t[st.peek()]) {
                int start = st.pop();
                int end = i;
                res[start] = end - start;
            }
            st.push(i);
        }
        return res;
    }
}
