// Convert Sorted List to Binary Search Tree
// bottom-up，时间复杂度O(n)，空间复杂度O(logn)
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        return sortedListToBST(new Container(head), 0, len - 1);
    }
    private static TreeNode sortedListToBST(Container list, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode leftChild = sortedListToBST(list, start, mid - 1);
        TreeNode parent = new TreeNode(list.p.val);
        parent.left = leftChild;
        list.p = list.p.next;
        parent.right = sortedListToBST(list, mid + 1, end);
        return parent;
    }
    // 模拟二级指针
    static class Container {
        ListNode p;
        public Container(ListNode p) {
            this.p = p;
        }
    }
}