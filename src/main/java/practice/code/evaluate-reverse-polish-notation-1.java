// Evaluate Reverse Polish Notation
// 递归，时间复杂度O(n)，空间复杂度O(logn)
// StackOverflowError
class Solution {
    public int evalRPN(final String[] tokens) {
        return evalRPN(tokens, tokens.length - 1);
    }
    private static int evalRPN(final String[] tokens, int i) {
        if (i < 0) return 0;
        int x, y;
        final String token = tokens[i--];
        if (isOperator(token))  {
            y = evalRPN(tokens, i--);
            x = evalRPN(tokens, i--);

            switch (token.charAt(0)) {
                case '+': x += y; break;
                case '-': x -= y; break;
                case '*': x *= y; break;
                default: x /= y;
            }
        } else  {
            x = Integer.parseInt(token);
        }
        return x;
    }
    private static boolean isOperator(final String op) {
        return op.length() == 1 && OPS.indexOf(op) != -1;
    }
    private static String OPS = new String("+-*/");
}