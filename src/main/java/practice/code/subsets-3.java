// Subsets
// 迭代版，时间复杂度O(2^n)，空间复杂度O(1)
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums); // 输出要求有序
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // empty subset
        for (int elem : nums) {
            final int n = result.size();
            for (int i = 0; i < n; ++i) { // copy itself
                result.add(new ArrayList<>(result.get(i)));
            }
            for (int i = n; i < result.size(); ++i) {
                result.get(i).add(elem);
            }
        }
        return result;
    }
}