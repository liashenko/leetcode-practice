class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            int freqCompare = freq.get(b) - freq.get(a);
            if (freqCompare != 0) return freqCompare;
                return a - b;
        });
        int[] res = new int[k];
        res[0] = arr[0];
        int j = 1;
        for (int i = 1; i < arr.length && k > 1; ++i) {
            if (arr[i] == arr[i-1]) continue;
            res[j++] = arr[i];
            k--;
        }
        return res;
    }
}
