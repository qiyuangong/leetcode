## Dungeon Game

The demons had captured the princess (**P**) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (**K**) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


**Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.**

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path `RIGHT-> RIGHT -> DOWN -> DOWN`.

```
+--------+----+--------+
| -2 (K) | -3 |    3   |
+--------+----+--------+
| -5     | -10|    1   |
+--------+----+--------+
| 10     | 30 | -5 (P) |
+--------+----+--------+
```


**Notes:**

* The knight's health has no upper bound.
* Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.


### 分析

这是一个多阶段优化问题，有广搜，贪心，动规。这题显然贪心不行，于是范围缩小到广搜和动规。本题求最小健康点数，跟路径长度无关，因此广搜不适合。最后只剩下了动规这个方向。

先定义状态，`f[i][j]`表示进入`(i,j)`这个格子前所需要的最小健康点数。

再考虑状态的初始值，我们发现右下角那个坐标才是初始值，起点`f[0][0]`反而不知道，于是大致可以知道，这题是从右下角向左上角来填表。右下角格子，如果该格子的值为负数，那么进入这个格子前骑士需要的健康点数是`-dungeon[i][j]+1`，即初始值`f[i][j]=-dungeon[i][j]+1`，如果格子的值是非负数，那么初始值`f[i][j]=1`。

接下来寻找状态转移方程。从初始值我们可以推测出状态转移是从右下角反向的，可以得到状态转移方程如下：

`f[i][j]=max(1, -dungeon[i][j]+min(f[i+1][j],f[i][j+1])`


### 代码

{% if book.java %}
{% codesnippet "./code/dungeon-game."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
