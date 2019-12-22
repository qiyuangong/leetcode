// Sort Colors
// Counting Sort
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3]; // 记录每个颜色出现的次数

        for (int i = 0; i < nums.length; i++)
            counts[nums[i]]++;

        for (int i = 0, index = 0; i < 3; i++)
            for (int j = 0; j < counts[i]; j++)
                nums[index++] = i;

    }
}