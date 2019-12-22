## Spiral Matrix


### 描述

Given a matrix of `m × n` elements (`m` rows, `n` columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

```
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
```

You should return `[1,2,3,6,9,8,7,4,5]`.


### 分析

模拟。

### 解法1 迭代

{% if book.java %}
```java
// Spiral Matrix
// 时间复杂度O(n^2)，空间复杂度O(1)
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        int beginX = 0, endX = matrix[0].length - 1;
        int beginY = 0, endY = matrix.length - 1;
        while (true) {
            // From left to right
            for (int j = beginX; j <= endX; ++j) result.add(matrix[beginY][j]);
            if (++beginY > endY) break;
            // From top to bottom
            for (int i = beginY; i <= endY; ++i) result.add(matrix[i][endX]);
            if (beginX > --endX) break;
            // From right to left
            for (int j = endX; j >= beginX; --j) result.add(matrix[endY][j]);
            if (beginY > --endY) break;
            // From bottom to top
            for (int i = endY; i >= beginY; --i) result.add(matrix[i][beginX]);
            if (++beginX > endX) break;
        }
        return result;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// LeetCode, Spiral Matrix
// @author 龚陆安 (http://weibo.com/luangong)
// 时间复杂度O(n^2)，空间复杂度O(1)
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> >& matrix) {
        vector<int> result;
        if (matrix.empty()) return result;
        int beginX = 0, endX = matrix[0].size() - 1;
        int beginY = 0, endY = matrix.size() - 1;
        while (true) {
            // From left to right
            for (int j = beginX; j <= endX; ++j) result.push_back(matrix[beginY][j]);
            if (++beginY > endY) break;
            // From top to bottom
            for (int i = beginY; i <= endY; ++i) result.push_back(matrix[i][endX]);
            if (beginX > --endX) break;
            // From right to left
            for (int j = endX; j >= beginX; --j) result.push_back(matrix[endY][j]);
            if (beginY > --endY) break;
            // From bottom to top
            for (int i = endY; i >= beginY; --i) result.push_back(matrix[i][beginX]);
            if (++beginX > endX) break;
        }
        return result;
    }
};
```
{% endif %}


### 解法2 递归

{% if book.java %}
```java
// Spiral Matrix
// 时间复杂度O(n^2)，空间复杂度O(1)
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        left = 0;
        right = matrix[0].length - 1;
        up = 0;
        down = matrix.length - 1;
        dfs(matrix, 0, 0, 0, result);
        return result;
    }

    private void dfs(int[][] matrix, int i, int j, int direction,
                     List<Integer> result) {
        if (i < up || i > down) return;
        if (j < left || j > right) return;
        result.add(matrix[i][j]);

        int nextDirection = (direction + 1) % 4;
        switch (direction) {
            case 0:  // right
                if (j < right) {
                    dfs(matrix, i, j + 1, direction, result);
                } else {
                    ++up;
                    dfs(matrix, i + 1, j, nextDirection, result);
                }
                break;
            case 1:  // down
                if (i < down) {
                    dfs(matrix, i+1, j, direction, result);
                } else {
                    --right;
                    dfs(matrix, i, j - 1, nextDirection, result);
                }
                break;
            case 2:  // left
                if (j > left) {
                    dfs(matrix, i, j - 1, direction, result);
                } else {
                    --down;
                    dfs(matrix, i - 1, j, nextDirection, result);
                }
                break;
            default: // up
                if (i > up) {
                    dfs(matrix, i - 1, j, direction, result);
                } else {
                    ++left;
                    dfs(matrix, i, j + 1, nextDirection, result);
                }
        }

    }

    private int left;
    private int right;
    private int up;
    private int down;
}
```
{% endif %}


### 相关题目

* [Spiral Matrix II](spiral-matrix-ii.md)
