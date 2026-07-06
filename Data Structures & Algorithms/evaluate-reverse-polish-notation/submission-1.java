// bruteforce: Scan and resolve operations iteratively in multiple passes, potentially O(N^2) time
// solution: Process tokens sequentially using a Stack to evaluate operands as operators are encountered, O(N) time / O(N) space
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> digits = new Stack<>();
        for (String token: tokens) {
            if ("+-*/".contains(token)) {
                int a = digits.pop();
                int b = digits.pop();
                digits.push(switch(token){
                    case "+" -> b + a;
                    case "-" -> b - a;
                    case "*" -> b * a;
                    case "/" -> b / a;
                    default -> throw new IllegalArgumentException("unknown operation");
                });
            } else {
                digits.push(Integer.parseInt(token));
            }
        }
        return digits.pop();
    }
}
