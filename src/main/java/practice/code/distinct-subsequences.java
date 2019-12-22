// Distinct Subsequences
// 二维动规+滚动数组
// 时间复杂度O(m*n)，空间复杂度O(n)
public class Solution {
    public int numDistinct(String s, String t) {
        int[] f = new int[t.length() + 1];
        f[0] = 1;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = t.length() - 1; j >= 0; --j) {
                f[j + 1] += s.charAt(i) == t.charAt(j) ? f[j] : 0;
            }
        }

        return f[t.length()];
    }
}