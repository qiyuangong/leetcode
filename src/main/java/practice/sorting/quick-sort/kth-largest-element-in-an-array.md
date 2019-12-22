## Kth Largest Element in an Array


### 描述

Find the `k`-th largest element in an unsorted array.

For example, given `[3,2,1,5,6,4]` and `k = 2`, return 5.

**Note**:

You may assume `k` is always valid, 1 ≤ k ≤ array's length.


### 分析

这题是一道很好的面试题目，

* 题目短小，很快就能说清题意
* 有很多种解法。从简单到复杂的解法都有，梯度均匀。
* 不需要预先知道特殊领域知识。

这题有很多思路：

1. 按从大到小全排序，然后取第`k`个元素，时间复杂度`O(nlogn)`，空间复杂度`O(1)`
1. 利用堆进行部分排序。维护一个大根堆，将数组元素全部压入堆，然后弹出`k`次，第`k`个就是答案。时间复杂度`O(klogn)`，空间复杂度`O(n)`
1. 选择排序，第`k`次选择后即可得到第`k`大的数，时间复杂度`O(nk)`，空间复杂度`O(1)`
1. 堆排序，维护一个`k`大小的小根堆，将数组中的每个元素与堆顶元素进行比较，如果比堆顶元素大，则删除堆顶元素并添加该元素，如果比堆顶元素小，则什么也不做，继续下一个元素。时间复杂度`O(nlogk)`，空间复杂度`O(k)`。
1. 利用快速排序中的partition思想，从数组中随机选择一个元素x，把数组划分为前后两部分`sa`和`sb`，`sa`中的元素小于x，`sb`中的元素大于或等于x。这时有两种情况：

    1. `sa`的元素个数小于`k`，则递归求解`sb`中的第`k-|sa|`大的元素
    1. `sa`的元素个数大于或等于`k`，则递归求解`sa`中的第`k`大的元素

    时间复杂度`O(n)`，空间复杂度`O(1)`


思路4和5比较高效，可以接受，其他思路太慢了，不采纳。


### 思路4 partition

{% if book.java %}
```java
// Kth Largest Element in an Array
// Time complexity: O(nlogk), Space complexity: O(k)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        final Queue<Integer> q = new PriorityQueue<>();

        for (int x : nums) {
            if (q.size() < k) {
                q.offer(x);
            } else {
                final int top = q.peek();
                if (x > top) {
                    q.poll();
                    q.offer(x);
                }
            }
        }
        return q.peek();
    }
}
```
{% endif %}


### 思路5 小根堆

{% if book.java %}
```java
// Kth Largest Element in an Array
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    private static int findKthLargest(int[] nums, int begin, int end, int k) {
        if (begin + 1 == end && k == 1) return nums[0];

        final int pos = partition(nums, begin, end - 1);
        final int len = pos - begin;

        if (len == k) {
            return nums[pos-1];
        } else if (len < k) {
            return findKthLargest(nums, pos, end, k - len);
        } else {
            return findKthLargest(nums, begin, pos, k);
        }
    }
    private static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            final int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }
    private static int partition(int[] nums, int i, int j) {
        final int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) --j;
            nums[i] = nums[j];
            while(i < j && nums[i] <= pivot) ++i;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }
}
```
{% endif %}
