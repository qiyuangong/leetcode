// Permutations
// 深搜，增量构造法
// 时间复杂度O(n!)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>(); // 中间结果

        dfs(nums, path, result);
        return result;
    }
    private static void dfs(int[] nums, List<Integer> path,
                            List<List<Integer>> result) {
        if (path.size() == nums.length) {  // 收敛条件
            result.add(new ArrayList<Integer>(path));
            return;
        }

        // 扩展状态
        for (int i : nums) {
            // 查找 i 是否在path 中出现过
            int pos = path.indexOf(i);

            if (pos == -1) {
                path.add(i);
                dfs(nums, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}