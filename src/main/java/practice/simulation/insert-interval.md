## Insert Interval


### 描述

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals `[1,3],[6,9]`, insert and merge `[2,5]` in as `[1,5],[6,9]`.

Example 2:
Given `[1,2],[3,5],[6,7],[8,10],[12,16]`, insert and merge `[4,9]` in as `[1,2],[3,10],[12,16]`.

This is because the new interval `[4,9]` overlaps with `[3,5],[6,7],[8,10]`.


### 分析

无


### 代码

{% if book.java %}
```java
struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) { }
    Interval(int s, int e) : start(s), end(e) { }
};
 
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
```
{% endif %}

{% if book.cpp %}
```cpp
// Insert Interval
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        vector<Interval>::iterator it = intervals.begin();
        while (it != intervals.end()) {
            if (newInterval.end < it->start) {
                intervals.insert(it, newInterval);
                return intervals;
            } else if (newInterval.start > it->end) {
                it++;
                continue;
            } else {
                newInterval.start = min(newInterval.start, it->start);
                newInterval.end = max(newInterval.end, it->end);
                it = intervals.erase(it);
            }
        }
        intervals.insert(intervals.end(), newInterval);
        return intervals;
    }
};
```
{% endif %}


### 相关题目

* [Merge Intervals](merge-intervals.md)
