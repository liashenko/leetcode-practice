// bruteforce: Use a simple delimiter that could occur in strings, potentially failing decoding
// solution: Encode using string length + '#' delimiter prefix, and decode by parsing length first, O(N) time / O(N) space
class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length());
            encoded.append("#");
            encoded.append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length();) {
            int n = str.charAt(i++) - '0';
            while (str.charAt(i) != '#') {
                n = n*10 + str.charAt(i++) - '0';
            }
            i++;
            String s = "";
            while (n-- > 0) {
                s += str.charAt(i++);
            }
            res.add(s);
        }
        return res;
    }
}
