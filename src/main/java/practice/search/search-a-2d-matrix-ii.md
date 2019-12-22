## Search a 2D Matrix II


### 描述

Write an efficient algorithm that searches for a value in an `m x n` matrix. This matrix has the following properties:

* Integers in each row are sorted in ascending from left to right.
* Integers in each column are sorted in ascending from top to bottom.

For example,

Consider the following matrix:

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```

Given target = `5`, return `true`.

Given target = `20`, return `false`.


### 分析

从右上角开始, 比较`target` 和 `matrix[i][j]`的值。如果小于`target`, 则该行不可能有此数,  所以`i++`; 如果大于`target`, 则该列不可能有此数, 所以`j--`。遇到边界则表明该矩阵不含`target`.


### 代码

{% if book.java %}
{% codesnippet "./code/search-a-2d-matrix-ii."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Search a 2D Matrix](search-a-2d-matrix.md)
