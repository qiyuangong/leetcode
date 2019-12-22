## Insertion Sort List


### 描述

Sort a linked list using insertion sort.


### 分析

无


### 代码


{% if book.java %}
```java
// Insertion Sort List
// 时间复杂度O(n^2)，空间复杂度O(1)
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        //dummy.next = head;

        for (ListNode cur = head; cur != null;) {
            ListNode pos = findInsertPos(dummy, cur.val);
            ListNode tmp = cur.next;
            cur.next = pos.next;
            pos.next = cur;
            cur = tmp;
        }
        return dummy.next;
    }

    ListNode findInsertPos(ListNode head, int x) {
        ListNode pre = null;
        for (ListNode cur = head; cur != null && cur.val <= x;
             pre = cur, cur = cur.next)
            ;
        return pre;
    }
}
```
{% endif %}

{% if book.cpp %}
```cpp
// Insertion Sort List
// 时间复杂度O(n^2)，空间复杂度O(1)
class Solution {
public:
    ListNode *insertionSortList(ListNode *head) {
        ListNode dummy(INT_MIN);
        //dummy.next = head;

        for (ListNode *cur = head; cur != nullptr;) {
            auto pos = findInsertPos(&dummy, cur->val);
            ListNode *tmp = cur->next;
            cur->next = pos->next;
            pos->next = cur;
            cur = tmp;
        }
        return dummy.next;
    }

    ListNode* findInsertPos(ListNode *head, int x) {
        ListNode *pre = nullptr;
        for (ListNode *cur = head; cur != nullptr && cur->val <= x;
            pre = cur, cur = cur->next)
            ;
        return pre;
    }
};
```
{% endif %}


### 相关题目

* [Sort List](../merge-sort/sort-list.md)
