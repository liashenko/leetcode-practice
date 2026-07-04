// bruteforce: Clean string and check all pairs from ends inward, O(N) time
// solution: Clean alphanumeric characters to lowercase, reverse using StringBuilder, and check equality, O(N) time / O(N) space
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder clean = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                clean.append(Character.toLowerCase(c));
            }
        }
        String cleaned = clean.toString();
        String reversed = clean.reverse().toString();
        return cleaned.equals(reversed);
    }
}
