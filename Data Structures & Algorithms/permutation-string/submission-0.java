// bruteforce: Generate all permutations of s1 and search them in s2, O(L1! * L2) time
// solution: Use sliding window frequency arrays of size 26, matching s1's character profile in s2, O(L2) time / O(1) space
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        for (char c : s1.toCharArray()) {
            a[c-'a']++;
        }
        int[] b = new int[26];
        int left = 0, right = 0;
        while (right < s2.length()) {
            // expand
            int c = s2.charAt(right) - 'a';
            b[c]++;
            right++;
            // 1. if not in s1, move left
            // 2. not enough chars in s1
            // a[c] == 0 || b[c] > a[c]
            while (b[c] > a[c]) {
                b[s2.charAt(left)-'a']--;
                left++;
            }
            // record
            if (right-left == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
