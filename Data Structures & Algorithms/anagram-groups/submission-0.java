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
