// Generate Parentheses
// 时间复杂度O(TODO)，空间复杂度O(n)
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if (n > 0) generate(n, path, result, 0, 0);
        return result;
    }
    // l 表示 ( 出现的次数, r 表示 ) 出现的次数
    private static void generate(int n, StringBuilder path,
                                 List<String> result, int l, int r) {
        if (l == n) {
            StringBuilder sb = new StringBuilder(path);
            for (int i = 0; i < n - r; ++i) sb.append(')');
            result.add(sb.toString());
            return;
        }

        path.append('(');
        generate(n, path, result, l + 1, r);
        path.deleteCharAt(path.length() - 1);

        if (l > r) {
            path.append(')');
            generate(n, path, result, l, r + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}