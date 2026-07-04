// bruteforce: Sort array elements by frequency directly, O(N log N) time
// solution: Use Bucket Sort where array indices represent frequencies to group elements, O(N) time / O(N) space
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = nums.length; i>=0; i--) {
            buckets[i] = new ArrayList<>();
        }
        // iterate freq and put element to buckets
        for (var e : freq.entrySet()) {
            var f = e.getValue();
            buckets[f].add(e.getKey());
        }
        int[] res = new int[k];
        int cnt = 0;
        for (int i = nums.length; i>=0; i--) {
            for (int n : buckets[i]) {
                if (cnt >= k) {
                    return res;
                }
                res[cnt++] = n;
            }
        }
        return res;
    }
}
