class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxFreq = 0, longest = 0;
        Map<Character, Integer> seen = new HashMap<>();
        while (right < s.length()) {
            // expand
            int freq = seen.getOrDefault(s.charAt(right), 0) + 1;
            seen.put(s.charAt(right), freq);
            right++;
            // update
            maxFreq = Math.max(maxFreq, freq);
            // fix the window
            while (right - left - maxFreq > k) {
                seen.put(s.charAt(left), seen.get(s.charAt(left))-1);
                left++;
            }
            // record
            longest = Math.max(longest, right-left);
        }
        return longest;
    }
}
