// Two Sum
// 方法2：hash。用一个哈希表，存储每个数对应的下标
// Time Complexity: O(n)，Space Complexity: O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            final Integer v = myMap.get(target-nums[i]);
            if (v != null && v > i) {
                return new int[]{i+1, v+1};
            }
        }
        return null;
    }
};