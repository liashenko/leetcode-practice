// bruteforce: For each day, scan forward to find the next warmer day, O(N^2) time
// solution: Use a monotonic decreasing deque storing indices to find the next warmer day in a single pass, O(N) time / O(N) space
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // bruteforce: just find next largest value O(N^2)
        // optimization: deque
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; ++i) {
            while (!deque.isEmpty() && temperatures[i]>temperatures[deque.getFirst()]) {
                int idx = deque.removeFirst();
                res[idx] = i-idx;
            }
            deque.addFirst(i);
        }
        return res;
    }
}
