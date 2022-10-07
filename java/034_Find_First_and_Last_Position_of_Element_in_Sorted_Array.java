class Solution {
    /*
        Rule 1
        - Given array is sorted in non-decreasing order
        
        Rule 2
        - Limit time complexity O(log n).
        
        So I can use Binary Search Algorithm.
    */
    public int[] searchRange(int[] nums, int target) {
        // initialize arr[0] -> maximum integer, arr[1] -> minimum integer
        int[] arr = {100001, -10};
        int s = 0;
        int e = nums.length - 1;
        
        // find minimum index in nums with Binary Search alogorithm
        while (s <= e) {
            
            int mid = (s + e) / 2;
            
            if(nums[mid] > target) {
                e = mid - 1;
            }
            else if(nums[mid] <= target) {
                if(nums[mid] == target) {
                    arr[0] = Math.min(arr[0], mid);
                    arr[1] = Math.max(arr[1], mid);
                }
                s = mid + 1;
            }
        }
        
        s = 0;
        e = nums.length - 1;
        
        // find maximum index in nums with Binary Search alogorithm
        while(s <= e) {
            int mid = (s + e) / 2;
            
            if(nums[mid] >= target) {
                if(nums[mid] == target) {
                    arr[0] = Math.min(arr[0], mid);
                    arr[1] = Math.max(arr[1], mid);
                }
                e = mid - 1;
            }
            else if(nums[mid] < target) {
                s = mid + 1;
            }
        }
        
        // if arr data is initial data, set -1.
        if(arr[0] == 100001) arr[0] = -1;
        if(arr[1] == -10) arr[1] = -1;
        
        return arr;
    }
}
