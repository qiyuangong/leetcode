## Scramble String


### 描述

Given a string `s1`, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of `s1 = "great"`:

```
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
```

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node `"gr"` and swap its two children, it produces a scrambled string `"rgeat"`.

```
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
```

We say that `"rgeat"` is a scrambled string of `"great"`.

Similarly, if we continue to swap the children of nodes `"eat"` and `"at"`, it produces a scrambled string `"rgtae"`.

```
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
```

We say that `"rgtae"` is a scrambled string of `"great"`.

Given two strings `s1` and `s2` of the same length, determine if `s2` is a scrambled string of `s1`.


### 分析

首先想到的是递归（即深搜），对两个string进行分割，然后比较四对字符串。代码虽然简单，但是复杂度比较高。有两种加速策略，一种是剪枝，提前返回；一种是加缓存，缓存中间结果，即memorization（翻译为记忆化搜索）。

剪枝可以五花八门，要充分观察，充分利用信息，找到能让节点提前返回的条件。例如，判断两个字符串是否互为scamble，至少要求每个字符在两个字符串中出现的次数要相等，如果不相等则返回false。

加缓存，可以用数组或HashMap。本题维数较高，用HashMap，`map`和`unordered_map`均可。

既然可以用记忆化搜索，这题也一定可以用动规。设状态为`f[n][i][j]`，表示长度为`n`，起点为`s1[i]`和起点为`s2[j]`两个字符串是否互为scramble，则状态转移方程为

```
f[n][i][j]} =  (f[k][i][j] && f[n-k][i+k][j+k]) 
            || (f[k][i][j+n-k] && f[n-k][i+k][j])
```


### 递归

{% codesnippet "./code/scramble-string-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 动规

{% codesnippet "./code/scramble-string-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 递归+剪枝

{% codesnippet "./code/scramble-string-3."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 备忘录法

{% codesnippet "./code/scramble-string-4."+book.suffix, language=book.suffix %}{% endcodesnippet %}
