// Remove Duplicates from Sorted Array
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;

        int index = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] != nums[index - 1])
                nums[index++] = nums[i];
        }
        return index;
    }
};
