class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]); //maxheap
        for (int n : freq.keySet()) {
            pq.offer(new int[]{freq.get(n), n});
        }
        int[] res = new int[k];
        int i = 0;
        while (k-- > 0) {
            res[i++] = pq.poll()[1];
        }
        return res;
    }
}
