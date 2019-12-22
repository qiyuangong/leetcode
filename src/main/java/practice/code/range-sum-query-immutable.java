// Range Sum Query - Immutable
public class NumArray {
    // Time Complexity: O(n), Space Complexity: O(1)
    public NumArray(int[] nums) {
        this.f = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            f[i] = sum;
        }
    }

    // Time Complexity: O(1), Space Complexity: O(1)
    public int sumRange(int i, int j) {
        return f[j] - (i == 0 ? 0 : f[i - 1]);
    }
    private final int[] f;
}