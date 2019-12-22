// Binary Tree Postorder Traversal
// 使用栈，时间复杂度O(n)，空间复杂度O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        /* p，正在访问的结点，q，刚刚访问过的结点*/
        TreeNode p = root;
        TreeNode q = null;

        do {
            while (p != null) { /* 往左下走*/
                s.push(p);
                p = p.left;
            }
            q = null;
            while (!s.empty()) {
                p = s.pop();
                /* 右孩子不存在或已被访问，访问之*/
                if (p.right == q) {
                    result.add(p.val);
                    q = p; /* 保存刚访问过的结点*/
                } else {
                    /* 当前结点不能访问，需第二次进栈*/
                    s.push(p);
                    /* 先处理右子树*/
                    p = p.right;
                    break;
                }
            }
        } while (!s.empty());

        return result;
    }
}