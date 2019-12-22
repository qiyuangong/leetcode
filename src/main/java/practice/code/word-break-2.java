// Word Break
// 动规，时间复杂度O(n^2)，空间复杂度O(n)
class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // 长度为n的字符串有n+1个隔板
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true; // 空字符串
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}