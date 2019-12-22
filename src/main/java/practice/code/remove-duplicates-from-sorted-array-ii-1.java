// Remove Duplicates from Sorted Array II
// Time complexity: O(n), Space Complexity: O(1)
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int index = 2;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }

        return index;
    }
};
