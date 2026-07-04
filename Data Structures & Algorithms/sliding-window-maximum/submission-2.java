// bruteforce: Find maximum in every window of size k, O(N * K) time
// solution: Use a Monotonic Deque storing indices in decreasing order of element values to track maximum, O(N) time / O(K) space
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // bruteforce
        // window K -> compute max - O(K)
        // move window n times
        // O(N*k), worst O(N^2)
        // optimal
        // window K - priority queue?
        // element and idx
        // pop while pq.idx < l, print top if idx >=l
        // O(NlogN)
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        //     return b[0] - a[0];
        // });
        // int l = 0, r = 0;
        // int[] res = new int[nums.length-k+1];
        // for (;r < nums.length;) {
        //     pq.offer(new int[]{nums[r], r});
        //     r++;
        //     // curr window
        //     if (r - l == k) {
        //         int[] top = pq.peek();
        //         res[l] = top[0];
        //         // move the window
        //         while (!pq.isEmpty() && l >= top[1]) {
        //             pq.poll();
        //             top = pq.peek();
        //         }
        //         l++;
        //     }
        // }
        // return res;
        // monotonic deque
        // remove all that are smaller from the back
        // add curr to the back
        // if left > front, remove it
        // window == k. add front to res
        Deque<Integer> d = new ArrayDeque<>();
        int l = 0, r = 0;
        int[] res = new int[nums.length-k+1];
        while (r < nums.length) {
            while (!d.isEmpty() && nums[d.peekLast()] < nums[r]) {
                d.removeLast();
            }
            d.offerLast(r);
            if (l > d.peekFirst()) {
                d.removeFirst();
            }
            if ((r+1) >= k) {
                res[l] = nums[d.peekFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
