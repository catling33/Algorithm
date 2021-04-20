package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        // sanity check
        // create adjacency list
        ArrayList<Integer>[] graph = new ArrayList[1000 + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }
        // hashset to dedup visited vertex
        Set<Integer> visited = new HashSet<>();
        // for each edge
        // if vertex are already in the list
        // check if can go from one vertex to the other trough list
        // dfs(graph, source, target)
        // otherwise, add edge to list
        for (int[] edge : edges) {
            visited.clear();
            int source = edge[0];
            int target = edge[1];
            if (!graph[source].isEmpty() && !graph[target].isEmpty() && dfs(graph, source, target, visited)) {
                return edge;
            }
            graph[target].add(source);
            graph[source].add(target);
        }
        throw new AssertionError();
    }
    // dfs
    private boolean dfs(List<Integer>[] graph, int source, int target, Set<Integer> visited) {
        // base case : if source is visited, return false
        // pass every neibough of the source to next recursion
        // if found -> return true
        if (!visited.contains(source)) {
            visited.add(source);
            if (source == target) {
                return true;
            }
            for (int nei : graph[source]) {
                if (dfs(graph, nei, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
