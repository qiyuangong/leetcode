// Super Ugly Number
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        final int[] nums = new int[n];
        nums[0] = 1; // 1 is the first ugly number
        final Queue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < primes.length; ++i) {
            q.add(new Node(0, primes[i], primes[i]));
        }

        for (int i = 1; i < n; ++i) {
            // get the min element and add to nums
            Node node = q.peek();
            nums[i] = node.val;

            // update top elements
            do {
                node = q.poll();
                node.val = nums[++node.index] * node.prime;
                q.add(node); // push it back
                // prevent duplicate
            } while (!q.isEmpty() && q.peek().val == nums[i]);
        }
        return nums[n - 1];
    }
    static class Node implements Comparable<Node> {
        private int index;
        private int val;
        private int prime;

        public Node(int index, int val, int prime) {
            this.index = index;
            this.val = val;
            this.prime = prime;
        }
        public int compareTo(Node other) {
            return this.val - other.val;
        }
    }
}