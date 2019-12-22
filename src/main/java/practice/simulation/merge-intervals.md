## Merge Intervals


### 描述

Given a collection of intervals, merge all overlapping intervals.

For example,
Given `[1,3],[2,6],[8,10],[15,18]`,
return `[1,6],[8,10],[15,18]`


### 分析

复用一下Insert Intervals的解法即可，创建一个新的interval集合，然后每次从旧的里面取一个interval出来，然后插入到新的集合中。


### 代码

{% if book.java %}
```java
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
```
{% endif %}

{% if book.cpp %}
```cpp
// Merge Interval
//复用一下Insert Intervals的解法即可
// 时间复杂度O(n1+n2+...)，空间复杂度O(1)
class Solution {
public:
    vector<Interval> merge(vector<Interval> &intervals) {
        vector<Interval> result;
        for (int i = 0; i < intervals.size(); i++) {
            insert(result, intervals[i]);
        }
        return result;
    }
private:
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

* [Insert Interval](insert-interval.md)
