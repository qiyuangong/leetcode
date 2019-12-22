// Subsets
// 增量构造法，深搜，时间复杂度O(2^n)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums); // 输出要求有序
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        subsets(nums, path, 0, result);
        return result;
    }

    private static void subsets(int[] nums, List<Integer> path, int step,
                                List<List<Integer>> result) {
        if (step == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        // 不选nums[step]
        subsets(nums, path, step + 1, result);
        // 选nums[step]
        path.add(nums[step]);
        subsets(nums, path, step + 1, result);
        path.remove(path.size() - 1);
    }
}