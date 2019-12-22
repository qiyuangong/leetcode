## Contains Duplicate


### 描述

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

### 分析

方法1， 用一个 HashSet, 不断往里面塞元素，如果发现有重复，说明存在重复。时间复杂度`O(n)`，空间复杂度`O(n)`。

方法2， 排序，然后从头到尾扫描，如果发现相邻两个元素相等，则存在重复。时间复杂度`O(nlogn)`，空间复杂度`O(1)`。


### 解法1 哈希表

{% if book.java %}
```java
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
```
{% endif %}


### 解法2 排序

{% if book.java %}
{% codesnippet "./code/contains-duplicate-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
