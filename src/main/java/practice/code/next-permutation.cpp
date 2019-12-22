// Next Permutation
// Time Complexity: O(n), Space Complexity: O(1)
class Solution {
public:
    void nextPermutation(vector<int> &nums) {
        next_permutation(nums, 0, nums.size());
    }
private:
    bool next_permutation(vector<int> &nums, int begin, int end) {
        // From right to left, find the first digit(partitionNumber) 
        // which violates the increase trend
        int p = end - 2;
        while (p > -1 && nums[p] >= nums[p + 1]) --p;

        // If not found, which means current sequence is already the largest
        // permutation, then rearrange to the first permutation and return false
        if(p == -1) {
            reverse(&nums[begin], &nums[end]);
            return false;
        }

        // From right to left, find the first digit which is greater
        // than the partition number, call it changeNumber
        int c = end - 1;
        while (c > 0 && nums[c] <= nums[p]) --c;

        // Swap the partitionNumber and changeNumber
        swap(nums[p], nums[c]);
        // Reverse all the digits on the right of partitionNumber
        reverse(&nums[p+1], &nums[end]);
        return true;
    }
};