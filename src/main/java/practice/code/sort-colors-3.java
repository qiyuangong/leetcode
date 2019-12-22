// Sort Colors
// 重新实现 partition()
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public void sortColors(int[] nums) {
        partition(nums, partition(nums, 0, nums.length, new EqualTo(0)),
                nums.length, new EqualTo(1));
    }
    private static int partition(int[] nums, int begin, int end, EqualTo predicate) {
        int pos = begin;

        for (; begin != end; ++begin)
            if (predicate.apply(nums[begin]))
                swap(nums, begin,pos++);

        return pos;
    }
    static class EqualTo {
        private final int target;
        public EqualTo(int target) {
            this.target = target;
        }
        public boolean apply(int x) {
            return x == target;
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}