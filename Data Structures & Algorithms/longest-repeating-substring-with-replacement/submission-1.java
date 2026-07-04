// bruteforce: Check all substrings and calculate max replacement counts, O(N^3) time
// solution: Use sliding window keeping frequency map, shrinking when window size minus max frequency exceeds k, O(N) time / O(N) space
class Solution {
    public int characterReplacement(String s, int k) {
        // X, Y, Y, X
        // you can do k replacements, return the longset substring containing only one char
        // sliding window contains 1 distinct character and replacements <= K
        int left = 0, right = 0;
        int longest = 0;
        int maxFreq = 0;
        Map<Character, Integer> seen = new HashMap<>();
        // X X X Y Y Y Y Y
        while (right < s.length()) {
            int freq = seen.getOrDefault(s.charAt(right), 0)+1;
            seen.put(s.charAt(right), freq);
            right++;
            maxFreq = Math.max(maxFreq, freq);
            while (right - left - maxFreq > k) {
                seen.put(s.charAt(left), seen.get(s.charAt(left))-1);
                left++;
            }
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}
