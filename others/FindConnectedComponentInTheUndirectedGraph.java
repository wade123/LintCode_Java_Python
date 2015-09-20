/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class FindConnectedComponentInTheUndirectedGraph {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (queue.isEmpty() && !set.contains(node)) {
                queue.offer(node);
            }
            ArrayList<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                UndirectedGraphNode cur = queue.poll();
                list = new ArrayList<>();
                list.add(cur.label);
                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (!set.contains(neighbor)) {
                        set.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}
