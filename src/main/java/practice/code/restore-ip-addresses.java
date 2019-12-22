// Restore IP Addresses
// 时间复杂度O(n^4)，空间复杂度O(n)
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> ip = new ArrayList<>();; // 存放中间结果
        dfs(s, ip, result, 0);
        return result;
    }

    /**
     * 解析字符串
     * @param[in] s 字符串，输入数据
     * @param[out] ip 存放中间结果
     * @param[out] result 存放所有可能的IP地址
     * @param[in] start 当前正在处理的 index
     * @return 无
     */
    private static void dfs(String s, List<String> ip,
                            List<String> result, int start) {
        if (ip.size() == 4 && start == s.length()) {  // 找到一个合法解
            result.add(ip.get(0) + '.' + ip.get(1) + '.' +
                    ip.get(2) + '.' + ip.get(3));
            return;
        }

        if (s.length() - start > (4 - ip.size()) * 3)
            return;  // 剪枝
        if (s.length() - start < (4 - ip.size()))
            return;  // 剪枝

        int num = 0;
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');

            if (num < 0 || num > 255) continue;  // 剪枝

            ip.add(s.substring(start, i + 1));
            dfs(s, ip, result, i + 1);
            ip.remove(ip.size() - 1);

            if (num == 0) break;  // 不允许前缀0，但允许单个0
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.restoreIpAddresses("1111");
    }
}