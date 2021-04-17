package BFS1;

import java.util.*;

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        // sanity check
        if (graph == null || graph.size() == 0) {
            return false;
        }
        // FIFO queue to store generated nodes
        Deque<GraphNode> queue = new ArrayDeque<>();
        // hashmap to store <node, group>
        Map<GraphNode, Integer> groupMap = new HashMap<>();
        // iterate through the starting node and do BFS
        for (GraphNode node : graph) {
            if (!bfs(node, queue, groupMap)) {
                return false;
            }
        }
        return true;
    }
    // BFS
    private boolean bfs(GraphNode node, Deque<GraphNode> queue, Map<GraphNode, Integer> groupMap) {
        // if the node is generated already, skip it
        if (groupMap.containsKey(node)) {
            return true;
        }
        // BFS
        // poll a node
        // generate neighbors and assign with opposite group
        queue.offer(node);
        groupMap.put(node, 1);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int group = groupMap.get(cur);
            for (GraphNode nei : cur.neighbors) {
                Integer neiGroup = groupMap.get(nei);
                if (neiGroup == null) {
                    groupMap.put(nei, group * -1);
                    queue.offer(nei);
                } else if (neiGroup == group) {
                    return false;
                }
            }
        }
        // return true
        return true;
    }

    public static void main(String[] args) {
        Bipartite sol = new Bipartite();
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node0 = new GraphNode(0);
        node0.neighbors.add(node1);
        node1.neighbors.add(node0);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        List<GraphNode> graph = new ArrayList<>();
        graph.add(node0);
        graph.add(node2);
        System.out.println(sol.isBipartite(graph));
    }
}
