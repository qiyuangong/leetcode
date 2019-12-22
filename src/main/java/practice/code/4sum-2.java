// 4Sum
// 先排序，然后左右夹逼
// Time Complexity: O(n^3)，Space Complexity: O(1)
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);

        final HashMap<Integer, ArrayList<int[]>> cache = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                ArrayList<int[]> value = cache.get(nums[i] + nums[j]);
                if (value == null) {
                    value = new ArrayList<>();
                    cache.put(nums[i] + nums[j], value);
                }
                value.add(new int[]{i, j});
            }
        }

        final HashSet<String> used = new HashSet<>(); // avoid duplicates
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                final ArrayList<int[]> list = cache.get(target - nums[i] - nums[j]);
                if (list == null) continue;;
                for (int[] pair : list) {
                    if (j >= pair[0]) continue;  // overlap
                    
                    final Integer[] sol = new Integer[]{nums[i], nums[j], nums[pair[0]], nums[pair[1]]};
                    Arrays.sort(sol);
                    final String key = Arrays.toString(sol);
                    
                    if(!used.contains(key)){
                        result.add(Arrays.asList(sol));
                        used.add(key);
                    }
                }
            }
        }
        return result;
    }
}