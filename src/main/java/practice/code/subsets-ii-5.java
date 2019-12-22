// Subsets II
// 二进制法，时间复杂度O(2^n)，空间复杂度O(1)
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // 必须排序
        // 用 set 去重，不能用 unordered_set，因为输出要求有序
        LinkedHashSet<ArrayList<Integer>> result = new LinkedHashSet<>();
        final int n = nums.length;
        ArrayList<Integer> v = new ArrayList<>();

        for (int i = 0; i < 1 << n; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i & 1 << j) > 0)
                    v.add(nums[j]);
            }
            result.add(new ArrayList<>(v));
            v.clear();
        }
        List<List<Integer>> realResult = new ArrayList<>();
        for (ArrayList<Integer> list : result) {
            realResult.add(list);
        }
        return realResult;
    }
}