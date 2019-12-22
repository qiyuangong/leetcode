## Permutation Sequence


### 描述

The set `[1,2,3,…,n]` contains a total of `n!` unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for `n = 3`):

```
"123"
"132"
"213"
"231"
"312"
"321"
```


Given `n` and `k`, return the kth permutation sequence.

Note: Given `n` will be between 1 and 9 inclusive.


### 分析

首先可以想到一个简单直白的方法，即调用 `k-1` 次 `next_permutation()`，从而得到第`k`个排列。这个方法把前`k`个排列全部求出来了，比较浪费，时间复杂度是 `O(kn)`，所以会超时。有没有办法直接求第`k`个排列呢？有！

利用康托编码的思路，假设有`n`个不重复的元素，第`k`个排列是$$a_1, a_2, a_3, ..., a_n$$，那么$$a_1$$是哪一个位置呢？

我们把$$a_1$$去掉，那么剩下的排列为
$$a_2, a_3, ..., a_n$$, 共计`n-1`个元素，`n-1`个元素共有`(n-1)!`个排列，于是就可以知道 $$a_1 = k / (n-1)!$$。

同理，$$a_2, a_3, ..., a_n$$ 的值推导如下：

$$k_2 = k\%(n-1)!$$

$$a_2 = k_2/(n-2)!$$

$$\quad \cdots$$

$$k_{n-1} = k_{n-2}\%2!$$

$$a_{n-1} = k_{n-1}/1!$$

$$a_n = 0$$


### 康托编码

{% codesnippet "./code/permutation-sequence."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 相关题目


* [Next Permutation](next-permutation.md)
* [Permutations](permutations.md)
* [Permutations II](permutations-ii.md)
* [Combinations](combinations.md)
