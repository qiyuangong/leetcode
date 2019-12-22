// Clone Graph
// BFS，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        // key is original node，value is copied node
        HashMap<UndirectedGraphNode,UndirectedGraphNode> visited = new HashMap<>();
        // each node in queue is already copied itself
        // but neighbors are not copied yet
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, new UndirectedGraphNode(node.label));
        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for (UndirectedGraphNode nbr : cur.neighbors) {
                // a copy already exists
                if (visited.containsKey(nbr)) {
                    visited.get(cur).neighbors.add(visited.get(nbr));
                } else {
                    UndirectedGraphNode new_node =
                            new UndirectedGraphNode(nbr.label);
                    visited.put(nbr, new_node);
                    visited.get(cur).neighbors.add(new_node);
                    q.offer(nbr);
                }
            }
        }
        return visited.get(node);
    }
}