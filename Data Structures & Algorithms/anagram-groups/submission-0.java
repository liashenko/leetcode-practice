// bruteforce: Compare every string with every other string to group anagrams, O(N^2 * K log K) time
// solution: Sort each string and use a HashMap to group strings with identical sorted representation, O(N * K log K) time / O(N * K) space
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String sorted = new String(sArr);
            groups
                .computeIfAbsent(sorted, k -> new ArrayList<>())
                .add(s);
        }
        for (var group : groups.values()) {
            result.add(group);
        }
        return result;
    }
}
