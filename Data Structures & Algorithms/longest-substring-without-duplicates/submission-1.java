// bruteforce: Check all substrings for duplicates, O(N^3) time
// solution: Use sliding window with a HashSet to store seen characters, shifting left pointer on duplicate, O(N) time / O(N) space
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int longest = 0;
        Set<Character> seen = new HashSet<>();
        // l..r
        // can extend r as long as we didnt see it
        // if we did, need to move l to the point
        while (r < s.length()) {
            while (l <= r && seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r++));
            longest = Math.max(longest, seen.size());
        }
        return longest;
    }
}
