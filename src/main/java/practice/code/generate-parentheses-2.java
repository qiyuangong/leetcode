// Generate Parentheses
// @author 连城 (http://weibo.com/lianchengzju)
public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("()"));
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; ++i)
            for (String inner : generateParenthesis (i))
                for (String outer : generateParenthesis (n - 1 - i))
                    result.add ("(" + inner + ")" + outer);

        return result;
    }
}