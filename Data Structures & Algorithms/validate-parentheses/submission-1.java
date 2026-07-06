// bruteforce: Repeatedly replace matching adjacent parenthesis pairs in the string until no matches remain, O(N^2) time
// solution: Use a Stack to push opening brackets and pop/verify them when matching closing brackets are encountered, O(N) time / O(N) space
class Solution {
    Map<Character, Character> map = Map.of(
        '(', ')', '{', '}', '[',']'
    );
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                st.push(c);
            } else {
                if (st.isEmpty() || map.get(st.pop()) != c) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
