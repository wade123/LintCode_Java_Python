/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; 
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        while (!queue.isEmpty()) {
            UndirectedGraphNode aNode = queue.poll();
            for (UndirectedGraphNode neighbor : aNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }
        for (UndirectedGraphNode aNode : map.keySet()) {
            for (UndirectedGraphNode neighbor : aNode.neighbors) {
                map.get(aNode).neighbors.add(map.get(neighbor));
            }
        }
        return nodeCopy;
    }
}