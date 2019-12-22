// Convert Sorted List to Binary Search Tree
// 二分法，类似于 Convert Sorted Array to Binary Search Tree，
// 自顶向下，时间复杂度O(nlogn)，空间复杂度O(logn)
class Solution {
public:
    TreeNode* sortedListToBST (ListNode* head) {
        if(head == nullptr) return nullptr;
        if(head->next == nullptr) return new TreeNode(head->val);
        
        ListNode *mid = cutAtMiddle(head);
        
        TreeNode *root = new TreeNode(mid->val);
        root->left = sortedListToBST(head);
        root->right = sortedListToBST(mid->next);
        
        return root;
    }

    ListNode* cutAtMiddle(ListNode *head) {
        if(head == nullptr) return nullptr;
        
        ListNode *fast = head;
        ListNode *slow = head;
        ListNode *prev_slow = head;

        while(fast != nullptr && fast->next != nullptr){
            prev_slow = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        prev_slow->next = nullptr;
        return slow;
    }
};