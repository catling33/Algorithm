package BFS1;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        // sanity check
        // count number of groups
        int count = 0;
        // int[] to mark visited nodes
        int[] visited = new int[isConnected.length];
        // iterate through each node
        // if the node is not visited before
        // count as a new group
        // visit its connected nodes through BFS
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                count++;
                bfs(i, visited, isConnected);
            }
        }
        // return count
        return count;
    }
    // BFS
    private void bfs(int node, int[] visited, int[][] isConnected) {
        // queue
        Queue<Integer> queue = new ArrayDeque<>();
        // initial status
        queue.offer(node);
        // for each step
        // poll a node
        // mark as visited
        // offer connected node into queue
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = 1;
            for (int nei = 0; nei < isConnected.length; nei++) {
                if (isConnected[cur][nei] == 1 && visited[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
    }
}
// TC = O(n^2)
// SC = O(n)