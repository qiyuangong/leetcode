## Implement Queue using Stacks


### 描述

Implement the following operations of a queue using stacks.

* push(x) -- Push element x to the back of queue.
* pop() -- Removes the element from in front of queue.
* peek() -- Get the front element.
* empty() -- Return whether the queue is empty.

**Notes**:

* You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
* Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
* You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).


### 分析

可以用两个栈，`s`和`tmp`，`s`存放元素，`tmp`用来作中转。

* `push(x)`，先将`s`中的元素全部弹出来，存入`tmp`，把`x` push 到`tmp`，然后把`tmp`中的元素全部弹出来，存入`s`
* `pop()`，直接将`s`的栈顶元素弹出来即可

该算法`push`的算法复杂度是`O(n)`, `pop`的算法复杂度`O(1)`。

另个一个方法是，让`pop`是`O(n)`, `push`是`O(1)`，思路很类似，就不赘述了。


### 代码

{% if book.java %}
{% codesnippet "./code/implement-queue-using-stacks."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Implement Stack using Queues](../stack/implement-stack-using-queues.md)
