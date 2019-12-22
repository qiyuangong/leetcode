// Subsets
// 二进制法，时间复杂度O(2^n)，空间复杂度O(1)
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums); // 输出要求有序
        List<List<Integer>> result = new ArrayList<>();
        final int n = nums.length;
        ArrayList<Integer> v = new ArrayList<>();

        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) > 0) v.add(nums[j]);
            }
            result.add(new ArrayList<>(v));
            v.clear();
        }
        return result;
    }
}