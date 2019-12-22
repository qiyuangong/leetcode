import java.util.*;

// Simplify Path
// 时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public String simplifyPath(String path) {
        Stack<String> dirs = new Stack<>();

        for (int i = 0; i < path.length();) {
            ++i;

            int j = path.indexOf('/', i);
            if (j < 0) j = path.length();
            final String dir = path.substring(i, j);

            // 当有连续 '///'时，dir 为空
            if (!dir.isEmpty() && !dir.equals(".")) {
                if (dir.equals("..")) {
                    if (!dirs.isEmpty())
                        dirs.pop();
                } else {
                    dirs.push(dir);
                }
            }

            i = j;
        }

        StringBuilder result = new StringBuilder();
        if (dirs.isEmpty()) {
            result.append('/');
        } else {
            for (final String dir : dirs) {
                result.append('/').append(dir);
            }
        }
        return result.toString();
    }
}