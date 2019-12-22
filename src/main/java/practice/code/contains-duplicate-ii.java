// Contains Duplicate II
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                final int preIndex = map.get(nums[i]);
                final int gap = i - preIndex;
                min = Math.min(min, gap);
            }
            map.put(nums[i], i);
        }
        return min <= k;
    }
}