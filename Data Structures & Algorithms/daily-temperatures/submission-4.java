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
