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
