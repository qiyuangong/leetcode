## Interleaving String


### 描述

Given `s1, s2, s3`, find whether `s3` is formed by the interleaving of `s1` and `s2`.

For example, Given: `s1 = "aabcc", s2 = "dbbca"`,

When `s3 = "aadbbcbcac"`, return true.

When `s3 = "aadbbbaccc"`, return false.


### 分析

设状态`f[i][j]`，表示`s1[0,i]`和`s2[0,j]`，匹配`s3[0, i+j]`。如果s1的最后一个字符等于s3的最后一个字符，则`f[i][j]=f[i-1][j]`；如果s2的最后一个字符等于s3的最后一个字符，则`f[i][j]=f[i][j-1]`。因此状态转移方程如下：

```
f[i][j] = (s1[i - 1] == s3 [i + j - 1] && f[i - 1][j])
       || (s2[j - 1] == s3 [i + j - 1] && f[i][j - 1]);
```


### 递归

{% codesnippet "./code/interleaving-string-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 动规

{% codesnippet "./code/interleaving-string-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}


### 动规+滚动数组

{% codesnippet "./code/interleaving-string-3."+book.suffix, language=book.suffix %}{% endcodesnippet %}
