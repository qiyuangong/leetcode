/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head==NULL)return NULL;
        if(head->next==NULL) return head;
        ListNode* p=head;
        ListNode* c=head->next;
        head->next=NULL;
        while(c->next){
            ListNode* n = c->next;
            c->next=p;
            p=c;
            c=n;
        }
        c->next=p;
        return c;
    }
};
