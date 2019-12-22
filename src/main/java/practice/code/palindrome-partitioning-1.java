// Palindrome Partitioning
// 时间复杂度O(2^n)，空间复杂度O(n)
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>(); // 一个partition方案
        dfs(s, path, result, 0, 1);
        return result;
    }

    // prev 表示前一个隔板, start 表示当前隔板
    private static void dfs(String s, List<String> path,
                            List<List<String>> result, int prev, int start) {
        if (start == s.length()) { // 最后一个隔板
            if (isPalindrome(s, prev, start - 1)) { // 必须使用
                path.add(s.substring(prev, start));
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        // 不断开
        dfs(s, path, result, prev, start + 1);
        // 如果[prev, start-1] 是回文，则可以断开，也可以不断开（上一行已经做了）
        if (isPalindrome(s, prev, start - 1)) {
            // 断开
            path.add(s.substring(prev, start));
            dfs(s, path, result, start, start + 1);
            path.remove(path.size() - 1);
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