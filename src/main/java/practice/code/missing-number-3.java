// Missing Number
// Time Complexity: O(nlogn), Space Complexity: O(1)
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int end = nums.length;
        while (begin != end) {
            final int mid = begin + (end - begin) / 2;
            if (mid < nums[mid]) end = mid;
            else begin = mid + 1;
        }
        return end;
    }
}