## Nim Game


### 描述

You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.


### 分析

这题是尼姆游戏的简化版。

尼姆游戏最流行的版本是用12枚硬币。

![](../images/nim-game-1.png)

游戏规则很简单，游戏双方轮流取 1 枚或多枚硬币（只能在同一行），谁拿到最后一枚就算赢。

有趣的是，有人发现，当扩展到任意多行，每行有任意枚硬币时，利用二进制，可以把这个游戏玩得风生水起。哈佛大学的数学教授布顿在 1901 年首次发表了论文详述了这个问题，也正是他，正式将这个游戏命名为**尼姆游戏**。

把玩家每一步操作之后的游戏局面叫做“棋局”。在布顿的论文中，如果玩家每一步操作后的棋局能保证自己获胜，那就是“安全的”，否则就是“不安全的”。每个不安全棋局都可以一步正确的操作变成安全的，而如果没有正确地操作，一个安全的棋局就会变成不安全的。

回到我们上面说的那个流行版本上，可以看到在初始状态，它的二进制表示如下图：

![](../images/nim-game-2.png)

可以看到，第 2 列之和为奇数，所以这个本版的初始状态是不安全的。拿掉最上面一行的 2 枚硬币，第 1 行就变成了 1 ，从而留下了一个安全棋局。通过用其他方法试验，可以看到，拿掉第 1 行的 2 枚硬币是留下安全棋局的唯一操作。

尼姆游戏深受数学家喜爱并被广泛研究，它因此产生了很多变体。1910 年美国数学家穆尔就提出了一个，它规则与尼姆游戏相同，只不过玩家可以从不超过指定数 k 的任意多行里拿掉硬币。有趣的是，它同样可以通过二进制来分析，只要把安全棋局定义为：二进制表里的每列之和都可以被 k + 1 整除就可以了。

这题是行数为1，k=3的简化版尼姆游戏。由于是先手，只需要判断当前的石头数能否被4整除，如果能整除，则一定会输，否则一定能赢。

**参考资料**: <http://www.guokr.com/article/68595/>


### 代码

{% if book.java %}
{% codesnippet "./code/nim-game."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}
