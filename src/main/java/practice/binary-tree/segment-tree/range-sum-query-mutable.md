## Range Sum Query - Mutable


### 描述

Given an integer array `nums`, find the sum of the elements between indices `i` and `j` (`i ≤ j`), inclusive.

The `update(i, val)` function modifies `nums` by updating the element at index `i` to `val`.

**Example**:

Given `nums = [1, 3, 5]`

```
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
```

**Note**:

1. The array is only modifiable by the update function.
1. You may assume the number of calls to update and sumRange function is distributed evenly.


### 分析

由于需要求任意段的和，且会随机修改元素，用线段树(Segment Tree)再合适不过了。

另外一个数据结构，树状数组(Binary Indexed Tree)，也适合解这道题。


### 解法1 线段树

{% if book.java %}
```java
// Range Sum Query - Mutable
// Segment Tree
public class NumArray {
    private SegmentTreeNode root;

    // Time Complexity: O(n)
    public NumArray(int[] nums) {
        this.root = buildTree(nums, 0, nums.length);
    }

    // Time Complexity: O(log n)
    void update(int i, int val) {
        updateHelper(this.root, i, val);
    }

    // Time Complexity: O(log n)
    public int sumRange(int i, int j) {
        return sumRangeHelper(this.root, i, j+1);
    }

    private static SegmentTreeNode buildTree(int[] nums, int begin, int end) {
        if (nums == null || nums.length == 0 || begin >= end)
            return null;
        if (begin == end - 1) // one element
            return new SegmentTreeNode(begin, end, nums[begin]);

        final SegmentTreeNode root = new SegmentTreeNode(begin, end);
        final int middle = begin + (end - begin) / 2;
        root.left = buildTree(nums, begin, middle);
        root.right = buildTree(nums, middle, end);
        root.sum = root.left.sum + root.right.sum;

        return root;
    }

    private static void updateHelper(SegmentTreeNode root, int i, int val) {
        if (root.begin == root.end - 1 && root.begin == i) {
            root.sum = val;
            return;
        }

        final int middle = root.begin + (root.end - root.begin) / 2;
        if (i < middle) {
            updateHelper(root.left, i, val);
        } else {
            updateHelper(root.right, i, val);
        }

        root.sum = root.left.sum + root.right.sum;
    }
    private static int sumRangeHelper(SegmentTreeNode root, int begin, int end) {
        if (root == null || begin >=root.end || end <= root.begin)
            return 0;
        if (begin <= root.begin && end >= root.end)
            return root.sum;

        final int middle = root.begin + (root.end - root.begin) / 2;
        return sumRangeHelper(root.left, begin, Math.min(end, middle)) +
                sumRangeHelper(root.right, Math.max(middle, begin), end);
    }

    static class SegmentTreeNode {
        private int begin;
        private int end;
        private int sum;
        private SegmentTreeNode left;
        private SegmentTreeNode right;

        public SegmentTreeNode(int begin, int end, int sum) {
            this.begin = begin;
            this.end = end;
            this.sum = sum;
        }
        public SegmentTreeNode(int begin, int end) {
            this(begin, end, 0);
        }
    }
}
```
{% endif %}


### 解法2 树状数组

{% if book.java %}
{% codesnippet "./code/range-sum-query-mutable-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Range Sum Query - Immutable](../../dp/range-sum-query-immutable.md)
* [Range Sum Query 2D - Immutable](../../dp/range-sum-query-2d-immutable.md)
