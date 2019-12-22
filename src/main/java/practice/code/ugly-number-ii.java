// Ugly Number II
// Time complexity: O(n), Space complexity: O(n)
// TODO: 没必要保存所有的ugly number, 空间可以优化到O(1)
public class Solution {
    public int nthUglyNumber(int n) {
        final int[] nums = new int[n];
        nums[0] = 1; // 1 is the first ugly number
        int index = 0, index2 = 0, index3 = 0, index5 = 0;

        while (index + 1 < n) {
            int x2 = nums[index2] * 2;
            int x3 = nums[index3] * 3;
            int x5 = nums[index5] * 5;
            int min = Math.min(x2, Math.min(x3, x5));

            if (min == x2) ++index2;
            else if (min == x3) ++index3;
            else ++index5;

            if (min != nums[index]) { // skip duplicate
                nums[++index] = min;
            }
        }
        return nums[n - 1];
    }
}