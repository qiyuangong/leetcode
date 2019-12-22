// Contains Duplicate
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> existed = new HashSet<>();
        for (int x : nums) {
            if (existed.contains(x)) {
                return true;
            } else {
                existed.add(x);
            }
        }
        return false;
    }
}