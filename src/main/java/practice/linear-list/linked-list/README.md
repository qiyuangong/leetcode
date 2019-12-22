本节主要讲关于单链表的算法。

单链表节点的定义如下：

{% if book.java %}
```java
// 单链表节点
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
```
{% endif %}


{% if book.cpp %}
```cpp
// 单链表节点
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) { }
};
```
{% endif %}
