// Word Break
// 深搜，超时
// 时间复杂度O(2^n)，空间复杂度O(n)
class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        return dfs(s, dict, 0, 1);
    }
    private static boolean dfs(String s, Set<String> dict,
                    int start, int cur) {
        if (cur == s.length()) {
            return dict.contains(s.substring(start, cur));
        }
        if (dfs(s, dict, start, cur+1)) return true; // no cut
        if (dict.contains(s.substring(start, cur))) // cut here
            if (dfs(s, dict, cur+1, cur+1)) return true;
        return false;
    }
}