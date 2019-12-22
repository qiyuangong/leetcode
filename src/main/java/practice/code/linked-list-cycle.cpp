// Linked List Cycle
// 时间复杂度O(n)，空间复杂度O(1)
class Solution {
public:
    bool hasCycle(ListNode *head) {
        // 设置两个指针，一个快一个慢
        ListNode *slow = head, *fast = head;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) return true;
        }
        return false;
    }
};