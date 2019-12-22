## Min Stack


### 描述

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

* `push(x)` -- Push element x onto stack.
* `pop()` -- Removes the element on top of the stack.
* `top()` -- Get the top element.
* `getMin()` -- Retrieve the minimum element in the stack.


### 分析

用两个栈，一个是真实的栈，另一个作为辅助栈，辅助栈每次 push 时，会把新元素跟当前栈顶元素进行比较，存入二者中较小的那个。

举个例子，对于序列 `18, 19, 21, 15, 17`, 两个栈依次`push`进去的元素是这样的：

* 真实栈，`18, 19, 21, 15, 17`
* 辅助栈，`18, 18, 18, 15, 15`

    具体过程是这样的，对于 `18`, 辅助栈是空的，直接push进去，当遇到`19`时，此时栈顶元素是`18`，二者中`18`较小，就把18插入，此时辅助栈中就有了两个`18`，当遇到`21`时，以此类推，还是插入`18`，遇到`15`时，栈顶元素是`18`，`15`较小，就把15压入，此时辅助栈中有3个`18`，1个`15`，当遇到`17`时，栈顶元素是`15`，二者中`15`是较小值，于是插入`15`，结束。


### 代码

{% if book.java %}
```java
// Min Stack
// Time Complexity: O(n), Space Complexity: O(1)
class MinStack {
    public void push(int x) {
        s.push(x);
        int minValue = minStack.isEmpty() ? x :
                Math.min(minStack.peek(), x);
        minStack.push(minValue);
    }

    public void pop() {
        s.pop();
        minStack.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
}
```
{% endif%}
