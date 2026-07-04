class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // bruteforce
        // window K -> compute max - O(K)
        // move window n times
        // O(N*k), worst O(N^2)
        // optimal
        // window K - priority queue?
        // element and idx
        // 3 2 1 5
        // 1, 1
        // 2, 2
        // 3, 3 1
        // 0, 4 2
        // 0, 5 3
        // 0, 6 4
        // pop while pq.idx < l, print top if idx >=l
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });
        int l = 0, r = 0;
        int[] res = new int[nums.length-k+1];
        for (;r < nums.length;) {
            pq.offer(new int[]{nums[r], r});
            r++;
            // curr window
            if (r - l == k) {
                int[] top = pq.peek();
                res[l] = top[0];
                // move the window
                while (!pq.isEmpty() && l >= top[1]) {
                    pq.poll();
                    top = pq.peek();
                }
                l++;
            }
        }
        return res;
    }
}
