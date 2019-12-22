// Palindrome Partitioning
// 时间复杂度O(2^n)，空间复杂度O(n)
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();  // 一个partition方案
        dfs(s, path, result, 0);
        return result;
    }
    // 搜索必须以s[start]开头的partition方案
    private static void dfs(String s, List<String> path,
                            List<List<String>> result, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) { // 从i位置砍一刀
                path.add(s.substring(start, i+1));
                dfs(s, path, result, i + 1);  // 继续往下砍
                path.remove(path.size() - 1); // 撤销上上行
            }
        }
    }
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            ++start;
            --end;
        }
        return start >= end;
    }
}