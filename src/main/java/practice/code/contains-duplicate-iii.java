// Contains Duplicate III
// Time Complexity: O(nlogk), Space Complexity: O(k)
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;

        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            final int x = nums[i];
            final Integer floor = set.floor(x);
            final Integer ceiling = set.ceiling(x);

            if ((floor != null && x <= floor + t)
                    || (ceiling != null && x >= ceiling -t))
                return true;

            set.add(x);
            if (i >= k) set.remove(nums[i - k]);
        }

        return false;
    }
}