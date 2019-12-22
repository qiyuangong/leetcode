// Subsets II
// 增量构造法，版本1，时间复杂度O(2^n)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // 必须排序

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(nums, 0, path, result);
        return result;
    }

    private static void dfs(int[] nums, int start, List<Integer> path,
                            List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(path));

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            dfs(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}