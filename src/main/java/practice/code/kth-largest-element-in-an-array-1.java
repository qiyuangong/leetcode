// Kth Largest Element in an Array
// Time complexity: O(nlogk), Space complexity: O(k)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        final Queue<Integer> q = new PriorityQueue<>();

        for (int x : nums) {
            if (q.size() < k) {
                q.offer(x);
            } else {
                final int top = q.peek();
                if (x > top) {
                    q.poll();
                    q.offer(x);
                }
            }
        }
        return q.peek();
    }
}