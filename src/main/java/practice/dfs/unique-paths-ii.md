## Unique Paths II


### 描述

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a `3 × 3` grid as illustrated below.

```
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
```

The total number of unique paths is 2.

Note: `m` and `n` will be at most 100.


### 备忘录法

在上一题的基础上改一下即可。相比动规，简单得多。

{% if book.java %}
{% codesnippet "./code/unique-paths-ii-1."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Unique Paths II
// 深搜 + 缓存，即备忘录法
class Solution {
public:
    int uniquePathsWithObstacles(const vector<vector<int> >& obstacleGrid) {
        const int m = obstacleGrid.size();
        const int n = obstacleGrid[0].size();
        if (obstacleGrid[0][0] || obstacleGrid[m - 1][n - 1]) return 0;

        f = vector<vector<int> >(m, vector<int>(n, 0));
        f[0][0] = obstacleGrid[0][0] ? 0 : 1;
        return dfs(obstacleGrid, m - 1, n - 1);
    }
private:
    vector<vector<int> > f;  // 缓存

    // @return 从 (0, 0) 到 (x, y) 的路径总数
    int dfs(const vector<vector<int> >& obstacleGrid,
            int x, int y) {
        if (x < 0 || y < 0) return 0; // 数据非法，终止条件

        // (x,y)是障碍
        if (obstacleGrid[x][y]) return 0;

        if (x == 0 and y == 0) return f[0][0]; // 回到起点，收敛条件

        if (f[x][y] > 0) {
            return f[x][y];
        } else {
            return f[x][y] = dfs(obstacleGrid, x - 1, y) + 
                dfs(obstacleGrid, x, y - 1);
        }
    }
};
```
{% endif %}


### 动规

与上一题类似，但要特别注意第一列的障碍。在上一题中，第一列全部是1，但是在这一题中不同，第一列如果某一行有障碍物，那么后面的行全为0。

{% if book.java %}
{% codesnippet "./code/unique-paths-ii-2."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}

{% if book.cpp %}
```cpp
// Unique Paths II
// 动规，滚动数组
// 时间复杂度O(n^2)，空间复杂度O(n)
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        const int m = obstacleGrid.size();
        const int n = obstacleGrid[0].size();
        if (obstacleGrid[0][0] || obstacleGrid[m-1][n-1]) return 0;

        vector<int> f(n, 0);
        f[0] = obstacleGrid[0][0] ? 0 : 1;

        for (int i = 0; i < m; i++) {
            f[0] = f[0] == 0 ? 0 : (obstacleGrid[i][0] ? 0 : 1);
            for (int j = 1; j < n; j++)
                f[j] = obstacleGrid[i][j] ? 0 : (f[j] + f[j - 1]);
        }

        return f[n - 1];
    }
};
```
{% endif %}


### 相关题目

* [Unique Paths](unique-paths.md)
* [Minimum Path Sum](../dp/minimum-path-sum.md)
