// Subsets
// 位向量法，深搜，时间复杂度O(2^n)，空间复杂度O(n)
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);  // 输出要求有序

        List<List<Integer>> result = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        subsets(nums, selected, 0, result);
        return result;
    }

    private static void subsets(int[] nums, boolean[] selected, int step,
                        List<List<Integer>> result) {
        if (step == nums.length) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (selected[i]) subset.add(nums[i]);
            }
            result.add(subset);
            return;
        }
        // 不选S[step]
        selected[step] = false;
        subsets(nums, selected, step + 1, result);
        // 选S[step]
        selected[step] = true;
        subsets(nums, selected, step + 1, result);
    }
}