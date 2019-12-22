// Merge Interval
//复用一下Insert Intervals的解法即可
// 时间复杂度O(n1+n2+...)，空间复杂度O(1)
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            insert(result, intervals.get(i));
        }
        return result;
    }
    private static List<Interval> insert(List<Interval> intervals,
                                         Interval newInterval) {
        for (int i = 0; i < intervals.size();) {
            final Interval cur = intervals.get(i);
            if (newInterval.end < cur.start) {
                intervals.add(i, newInterval);
                return intervals;
            } else if (newInterval.start > cur.end) {
                ++i;
                continue;
            } else {
                newInterval.start = Math.min(newInterval.start, cur.start);
                newInterval.end = Math.max(newInterval.end, cur.end);
                intervals.remove(i);
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}