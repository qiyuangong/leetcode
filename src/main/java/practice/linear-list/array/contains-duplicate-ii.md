## Contains Duplicate II


### 描述

Given an array of integers and an integer `k`, find out whether there are two distinct indices `i` and `j` in the array such that `nums[i] = nums[j]` and the difference between `i` and `j` is at most `k`.


### 分析

维护一个HashMap, key为整数，value为下标，将数组中的元素不断添加进这个HashMap, 碰到重复时，计算二者的下标距离，如果距离小于或等于k，则返回true, 如果直到数组扫描完，距离都大于k，则返回false。


### 代码

{% if book.java %}
```java
// Contains Duplicate II
// Time Complexity: O(n), Space Complexity: O(n)
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                final int preIndex = map.get(nums[i]);
                final int gap = i - preIndex;
                min = Math.min(min, gap);
            }
            map.put(nums[i], i);
        }
        return min <= k;
    }
}
```
{% endif %}
