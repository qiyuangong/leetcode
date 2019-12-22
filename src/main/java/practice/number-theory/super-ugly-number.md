## Super Ugly Number


### 描述

Write a function to find the `n`-th super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list `primes` of size `k`. For example, `[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]` is the sequence of the first 12 super ugly numbers given `primes = [2, 7, 13, 19]` of size 4.

**Note**:

1. 1 is a super ugly number for any given `primes`.
2. The given numbers in `primes` are in ascending order.
3. 0 < `k` ≤ 100, 0 < `n` ≤ 1000000, 0 < `primes[i]` < 1000.


### 分析

这题是 [Ugly Number II](ugly-number-ii.md) 的扩展。在"Ugly Number II"中，`primes=[2,3,5]`，这题中`primes`可以自由变化。

所以这题可以用"Ugly Number II"的思路解决。每次要从多个列表中选择最小的元素，我们可以维护一个大小为`primes`长度的小根堆。


### 代码

{% if book.java %}
```java
// Super Ugly Number
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        final int[] nums = new int[n];
        nums[0] = 1; // 1 is the first ugly number
        final Queue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < primes.length; ++i) {
            q.add(new Node(0, primes[i], primes[i]));
        }

        for (int i = 1; i < n; ++i) {
            // get the min element and add to nums
            Node node = q.peek();
            nums[i] = node.val;

            // update top elements
            do {
                node = q.poll();
                node.val = nums[++node.index] * node.prime;
                q.add(node); // push it back
                // prevent duplicate
            } while (!q.isEmpty() && q.peek().val == nums[i]);
        }
        return nums[n - 1];
    }
    static class Node implements Comparable<Node> {
        private int index;
        private int val;
        private int prime;

        public Node(int index, int val, int prime) {
            this.index = index;
            this.val = val;
            this.prime = prime;
        }
        public int compareTo(Node other) {
            return this.val - other.val;
        }
    }
}
```
{% endif %}


### 相关题目

* [Ugly Number II](ugly-number-ii.md)
