## Implement Stack using Queues


### 描述

Implement the following operations of a stack using queues.

* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* empty() -- Return whether the stack is empty.

**Notes**:

* You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
* Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
* You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).


### 分析

可以用两个队列，`q`和`tmp`，`q`存放元素，`tmp`用来作中转。

* `push(x)`，先将`x` push 到`tmp`，然后把`q`中的元素全部弹出来，存入`tmp`，最后切换`q`和`tmp`
* `pop()`，直接将`q`的队首元素弹出来即可

该算法`push`的算法复杂度是`O(n)`, `pop`的算法复杂度`O(1)`。

另个一个方法是，让`pop`是`O(n)`, `push`是`O(1)`，思路很类似，就不赘述了。


### 代码

{% if book.java %}
{% codesnippet "./code/implement-stack-using-queues."+book.suffix, language=book.suffix %}{% endcodesnippet %}
{% endif %}


### 相关题目

* [Implement Queue using Stacks](../queue/implement-queue-using-stacks.md)
