// Longest Increasing Subsequence
// 时间复杂度O(nlogn)，空间复杂度O(n)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> lis = new ArrayList<>();
        for (int x : nums) {
            int insertPos = lowerBound(lis, 0, lis.size(), x);
            if (insertPos >= lis.size()) {
                lis.add(x);
            } else {
                lis.set(insertPos, x);
            }
        }
        return lis.size();
    }
    private static int lowerBound (ArrayList<Integer> A,
                                   int first, int last, int target) {
        while (first != last) {
            int mid = first + (last - first) / 2;
            if (target > A.get(mid)) first = ++mid;
            else                 last = mid;
        }

        return first;
    }
}