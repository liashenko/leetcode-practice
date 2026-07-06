// bruteforce: For each get(key, timestamp), scan all timestamps for that key linearly, O(N) per query
// solution: Store timestamps in sorted lists per key, use upper bound binary search to find largest timestamp <= target, O(log N) per query / O(N) space
class TimeMap {

    Map<String, List<Integer>> timestamps = new HashMap<>();
    Map<String, List<String>> values = new HashMap<>();

    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        // key -> list<timestamp>
        // key -> list<value>
        timestamps.computeIfAbsent(key, k -> new ArrayList<>())
            .add(timestamp);
        values.computeIfAbsent(key, k -> new ArrayList<>())
            .add(value);
    }
    
    public String get(String key, int timestamp) {
        // find upper bound t > timestamp
        // return id[t]-1 or "" if id=0
        if (!timestamps.containsKey(key)) {
            return "";
        }
        List<Integer> keyTimestamps = timestamps.get(key);
        int upperBound = findUpperBound(keyTimestamps, timestamp);
        return upperBound == 0 ? "" : values.get(key).get(upperBound-1);
    }

    private int findUpperBound(List<Integer> v, int t) {
        int l = 0, r = v.size();
        while (l < r) {
            int mid = l + (r-l)/2;
            if (v.get(mid) > t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
