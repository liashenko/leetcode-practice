class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int longest = 0;
        Map<Character, Integer> seen = new HashMap<>();
        // l..r
        // can extend r as long as we didnt see it
        // if we did, need to move l to the point
        while (r < s.length()) {
            if (seen.containsKey(s.charAt(r))) {
                l = Math.max(seen.get(s.charAt(r)) + 1, l);
            }
            seen.put(s.charAt(r), r);
            longest = Math.max(longest, r-l+1);
            r++;
        }
        return longest;
    }
}
