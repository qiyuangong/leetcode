// Max Points on a Line
// 迭代，时间复杂度O(n)，空间复杂度O(logn)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for (String token : tokens) {
            if (!isOperator(token)) {
                s.push(token);
            } else {
                int y = Integer.parseInt(s.pop());
                int x = Integer.parseInt(s.pop());
                switch (token.charAt(0)) {
                    case '+': x += y; break;
                    case '-': x -= y; break;
                    case '*': x *= y; break;
                    default: x /= y;
                }
                s.push(String.valueOf(x));
            }
        }
        return Integer.parseInt(s.peek());
    }
    private static boolean isOperator(final String op) {
        return op.length() == 1 && OPS.indexOf(op) != -1;
    }
    private static String OPS = new String("+-*/");
}