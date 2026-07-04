// bruteforce: Check all substrings to find the shortest containing all target characters, O(N^3) time
// solution: Use a sliding window with maps tracking character frequencies and a match counter to shrink dynamically, O(N) time / O(N) space
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        // record count characters in t
        // sliding window in s
        // record count in s, and check if it matches t
        // as matches==0, move left
        // when matches==t.length, save the window, but then move left until the characters match
        // and try to find the smallest?
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> source = new HashMap<>();
        int l = 0, r = 0;
        int matches = 0;
        char[] arr = s.toCharArray();
        String res = "";
        int minWindow = Integer.MAX_VALUE;
        while (r < arr.length) {
            // update right
            char rightChar = arr[r];
            int freq = source.getOrDefault(rightChar, 0) + 1;
            source.put(rightChar, freq);
            r++;
            // update matches
            if (freq <= target.getOrDefault(rightChar, 0)) {
                matches++;
            }
            // if matched all unique characters
            while (matches == t.length()) {
                if (r-l < minWindow) {
                    res = s.substring(l, r);
                    minWindow = r-l;
                }
                char leftChar = arr[l];
                l++;
                int leftFreq = source.get(leftChar)-1;
                source.put(leftChar, leftFreq);
                // if the window has less chars than target requires
                // 1. leftFreq = 0, target requires 1 -> matches--
                // 2. leftFreq = 1, target requires 1 -> x
                // 3. leftFreq = 2, target requires 1 -> x
                if (leftFreq < target.getOrDefault(leftChar, 0)) {
                    matches--;
                }
            }
        }
        return res;
    }
}
