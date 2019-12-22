// Remove Duplicates from Sorted Array II
// Time Complexity: O(n), Space Complexity: O(1)
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && i < n - 1 && nums[i] == nums[i - 1] && nums[i] == nums[i + 1])
                continue;

            nums[index++] = nums[i];
        }
        return index;
    }
};
