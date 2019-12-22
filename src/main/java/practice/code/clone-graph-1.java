// Clone Graph
// DFS，时间复杂度O(n)，空间复杂度O(n)
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        // key is original node，value is copied node
        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        clone(node, visited);
        return visited.get(node);
    }
    // DFS
    private static UndirectedGraphNode clone(UndirectedGraphNode node,
                                              HashMap<UndirectedGraphNode,
                                                      UndirectedGraphNode> visited) {
        // a copy already exists
        if (visited.containsKey(node)) return visited.get(node);

        UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
        visited.put(node, new_node);
        for (UndirectedGraphNode nbr : node.neighbors)
            new_node.neighbors.add(clone(nbr, visited));
        return new_node;
    }
}