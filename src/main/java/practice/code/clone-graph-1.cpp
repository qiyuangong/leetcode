// Clone Graph
// DFS，时间复杂度O(n)，空间复杂度O(n)
class Solution {
public:
    UndirectedGraphNode *cloneGraph(const UndirectedGraphNode *node) {
        if(node == nullptr) return nullptr;
        // key is original node，value is copied node
        unordered_map<const UndirectedGraphNode *,
                            UndirectedGraphNode *> visited;
        clone(node, visited);
        return visited[node];
    }
private:
    // DFS
    static UndirectedGraphNode* clone(const UndirectedGraphNode *node,
            unordered_map<const UndirectedGraphNode *,
            UndirectedGraphNode *> &visited) {
        // a copy already exists
        if (visited.find(node) != visited.end()) return visited[node];

        UndirectedGraphNode *new_node = new UndirectedGraphNode(node->label);
        visited[node] = new_node;
        for (auto nbr : node->neighbors)
            new_node->neighbors.push_back(clone(nbr, visited));
        return new_node;
    }
};