// Combination Sum
// 时间复杂度O(n!)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(); // 最终结果
        List<Integer> path = new ArrayList<>(); // 中间结果
        dfs(nums, path, result, target, 0);
        return result;
    }

    private static void dfs(int[] nums, List<Integer> path, 
                            List<List<Integer>> result, int gap, int start) {
        if (gap == 0) {  // 找到一个合法解
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) { // 扩展状态
            if (gap < nums[i]) return; // 剪枝

            path.add(nums[i]); // 执行扩展动作
            dfs(nums, path, result, gap - nums[i], i);
            path.remove(path.size() - 1);  // 撤销动作
        }
    }
}