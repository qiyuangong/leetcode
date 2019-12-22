// Insert Interval
// 时间复杂度O(n)，空间复杂度O(1)
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
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