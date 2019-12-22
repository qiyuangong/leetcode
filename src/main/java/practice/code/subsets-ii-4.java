// Subsets II
// 增量构造法
// 时间复杂度O(2^n)，空间复杂度O(1)
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // 必须排序
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());

        int previous_size = 0;
        for (int i = 0; i < nums.length; ++i) {
            final int size = result.size();
            for (int j = 0; j < size; ++j) {
                if (i == 0 || nums[i] != nums[i-1] || j >= previous_size) {
                    result.add(new ArrayList<>(result.get(j)));
                    result.get(result.size() - 1).add(nums[i]);
                }
            }
            previous_size = size;
        }
        return result;
    }
}