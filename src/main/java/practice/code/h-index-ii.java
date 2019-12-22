// H-Index II
// Time complexity: O(logn), Space complexity: O(1)
public class Solution {
    public int hIndex(int[] citations) {
        final int n = citations.length;
        int begin = 0;
        int end = citations.length;

        while (begin < end) {
            final int mid = begin + (end - begin) / 2;
            if (citations[mid] < n - mid) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return n - begin;
    }
}