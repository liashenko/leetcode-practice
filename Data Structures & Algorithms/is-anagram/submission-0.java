// bruteforce: Count character occurrences using nested loops, O(N^2) time
// solution: Sort both strings and verify if their sorted representations are equal, O(N log N) time / O(N) space
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for (int i = 0;i < sArray.length; ++i) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
}
