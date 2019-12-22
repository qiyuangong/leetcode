## Game of Life


### 描述

According to the [Wikipedia's article](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life): "The **Game of Life**, also known simply as **Life**, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
1. Any live cell with two or three live neighbors lives on to the next generation.
1. Any live cell with more than three live neighbors dies, as if by over-population..
1. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.

**Follow up**:

1. Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
2. In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?


### 分析

最简单的办法是新建一个矩阵保存下一轮局面。

不过本提要求 inplace, 难度就瞬间增大了。因为我们修改一个位置的值后，它的旧值就丢失了，而它周围还有邻居依赖它的旧值。

因为题目给出的是一个int矩阵，大有空间可以利用。我们可以换一种方式进行编码，假设对于每个点，值的含义为：

* 状态0：死细胞转为死细胞
* 状态1：活细胞转为活细胞
* 状态2：活细胞转为死细胞
* 状态3：死细胞转为活细胞

得到这样一个矩阵后，最后将所有状态对2取模，状态0和2变成死细胞，1和3变成活细胞，就是所求的下一轮局面了。


### 代码

{% if book.java %}
{% codesnippet "./code/game-of-life."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
