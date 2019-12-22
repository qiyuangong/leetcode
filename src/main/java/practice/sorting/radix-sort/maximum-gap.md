## Maximum Gap

### 描述

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.


### 分析

这道题最直接的解法是，先排序，得到有序数组，然后相邻元素相减，找出差最大的，时间复杂度`O(n log n)`。

然而本题要求`O(n)`时间，有没有`O(n)`的排序算法呢？桶排序、基数排序、计数排序。


### 解法1 桶排序

{% if book.java %}
```java
// Maximum Gap
// Bucket Sort
// Time Complexity: O(n+k), Space Complexity: O(n+k)
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        bucketSort(nums);

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i - 1]);
        }
        return maxDiff;
    }

    private static void bucketSort(int[] nums) {
        if (nums.length < 2) return;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i : nums) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);
        }

        final int bucketSize = (maxValue - minValue) / nums.length + 1;
        final int bucketCount = (maxValue - minValue) / bucketSize + 1;
        final ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for (int x : nums) {
            final int index = (x - minValue) / bucketSize;
            buckets[index].add(x);
        }

        for (final ArrayList<Integer> list : buckets) {
            Collections.sort(list);
        }

        int i = 0;
        for (final ArrayList<Integer> list : buckets) {
            for (int x : list) {
                nums[i++] = x;
            }
        }
    }
}
```
{% endif %}


### 解法2 基数排序

{% if book.java %}
```java
// Maximum Gap
// Radix Sort
// Time Complexity: O(nd), Space Complexity: O(n+d)
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        radixSort(nums);

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i - 1]);
        }
        return maxDiff;
    }
    private static void radixSort(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i : nums) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);
        }

        final int D = Integer.toString(maxValue - minValue).length();
        final ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < D; ++i) {
            for (int x : nums) {
                final int index = getDigit(x - minValue, i);
                final ArrayList<Integer> bucket = buckets[index];
                bucket.add(x);
            }

            int index = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (int x : bucket) {
                    nums[index++] = x;
                }
                bucket.clear();
            }
        }
    }

    // get the i-th digit of n
    private static int getDigit(int n, int i) {
        for (int j = 0; j < i; ++j) {
            n /= 10;
        }
        return n % 10;
    }
}
```
{% endif %}


### 解法3 计数排序

计数排序本质上是一种特殊的桶排序，当桶的个数最大的时候，就是计数排序。

本题用计数排序会MLE。

{% if book.java %}
{% codesnippet "./code/maximum-gap-3."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
