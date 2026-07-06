// bruteforce: For each element in nums1, find its index in nums2 and scan rightward for the next greater element, O(N * M) time
// solution: Traverse nums2 from right to left maintaining a monotonic decreasing stack to precompute next greater elements, O(N + M) time / O(M) space
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] next = new int[10005];
        // monotonic decreasing stack
        // go from the back
        // pop if smaller and until we find greater
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length-1;i>=0;i--) {
            int n = nums2[i];
            while (!st.isEmpty() && st.peek() <= n) {
                st.pop();
            }
            int g = st.isEmpty() ? -1 : st.peek();
            next[n] = g;
            st.push(n);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = next[nums1[i]];
        }
        return res;
    }
}
