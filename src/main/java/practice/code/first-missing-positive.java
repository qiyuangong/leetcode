// First Missing Positive
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public int firstMissingPositive(int[] nums) {
        bucket_sort(nums);

        for (int i = 0; i < nums.length; ++i)
            if (nums[i] != (i + 1))
                return i + 1;
        return nums.length + 1;
    }
    private static void bucket_sort(int[] A) {
        final int n = A.length;
        for (int i = 0; i < n; i++) {
            while (A[i] != i + 1) {
                if (A[i] < 1 || A[i] > n || A[i] == A[A[i] - 1])
                    break;
                // swap
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
    }
}