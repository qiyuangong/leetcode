// Letter Combinations of a Phone Number
// 时间复杂度O(3^n)，空间复杂度O(1)
public class Solution {
    private static final String[] keyboard =
            new String[]{ " ", "", "abc", "def", // '0','1','2',...
                    "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        result.add("");
        for (char d : digits.toCharArray()) {
            final int n = result.size();
            final int m = keyboard[d - '0'].length();
            
            // resize to n * m
            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    result.add(result.get(j));
                }
            }

            for (int i = 0; i < result.size(); ++i) {
                result.set(i, result.get(i) + keyboard[d - '0'].charAt(i/n));
            }
        }
        return result;
    }
}