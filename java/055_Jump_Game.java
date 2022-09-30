import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        /*
         * Constraints
         * 1 <= nums.length <= 10^4
         * 0 <= nums[i] <= 10^5
         * 
         * Solution
         * 1. Use BFS Algorithm.
         *   - reason 1 : have to ignore array which is not visited.
         *   - reason 2 : we have to visit all possible array from array[start].
         */

        int N = nums.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        
        // First, add first array index.
        // And, set visited[first_index] to true.
        q.add(0);
        visited[0] = true;
        
        // Axiom : if N is 1, result is true.
        if(N == 1) return true;
        
        // BFS algorithm
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            // find cur + 1 to cur + nums[cur]
            for(int i = 1; i <= nums[cur]; i++) {
                if(cur + i >= N - 1) return true;
                int next = Math.min(cur + i, N - 1);
                
                // set visited[next] to true and add index into queue.
                // because of time limit(No overlap steps.)
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        
        return false;
        
    }
}