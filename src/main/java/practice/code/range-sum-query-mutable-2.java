// Range Sum Query - Mutable
// Binary Indexed Tree
public class NumArray {
    private int[] nums;
    private int[] bit;

    // Time Complexity: O(n)
    public NumArray(int[] nums) {
        // index 0 is unused
        this.nums = new int[nums.length + 1];
        this.bit = new int[nums.length + 1];

        for (int i = 0; i < nums.length; ++i) {
            update(i, nums[i]);
        }
    }

    // Time Complexity: O(log n)
    public void update(int index, int val) {
        final int diff = val - nums[index + 1];
        for (int i = index + 1; i < nums.length; i += lowbit(i)) {
            bit[i] += diff;
        }
        nums[index + 1] = val;
    }

    // Time Complexity: O(log n)
    public int sumRange(int i, int j) {
        return read(j + 1) - read(i);
    }

    private int read(int index) {
        int result = 0;
        for (int i = index; i > 0; i -= lowbit(i)) {
            result += bit[i];
        }
        return result;
    }

    private static int lowbit(int x) {
        return x & (-x);  // must use parentheses
    }
}