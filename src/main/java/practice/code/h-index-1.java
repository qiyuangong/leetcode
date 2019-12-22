// H-Index
// Time complexity: O(nlogn), Space complexity: O(1)
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        reverse(citations);
        for (int i = 0; i < citations.length; ++i) {
            if (i + 1 == citations[i]) return i+1;
            if (i + 1 > citations[i]) return i;
        }
        return citations.length;
    }
    private static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            final int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            ++left;
            --right;
        }
    }
}