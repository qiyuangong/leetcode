// Letter Combinations of a Phone Number
// 时间复杂度O(3^n)，空间复杂度O(n)
public class Solution {
    private static final String[] keyboard =
            new String[]{ " ", "", "abc", "def", // '0','1','2',...
            "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        dfs(digits, 0, "", result);
        return result;
    }

    private static void dfs(String digits, int cur, String path,
                            List<String> result) {
        if (cur == digits.length()) {
            result.add(path);
            return;
        }
        final String str = keyboard[digits.charAt(cur) - '0'];
        
        for (char c : keyboard[digits.charAt(cur) - '0'].toCharArray()) {
            dfs(digits, cur + 1, path + c, result);
        }
    }
}