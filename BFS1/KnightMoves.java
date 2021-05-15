package BFS1;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class KnightMoves {
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        // FIFO queue to store cells visited in last round
        Queue<int[]> queue = new ArrayDeque<>();
        // set to dedup
        Set<String> visited = new HashSet<>();
        // record the steps so far
        int step = 0;
        // initialize
        int[] start = new int[]{0, 0};
        queue.offer(start);
        visited.add(start[0] + "," + start[1]);
        // directions
        int[][] directions = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
        // BFS
        // increment step
        // record size
        // for each cell in the queue
        // expand a cell
        // generate neis
        // if nei generated is desitnation --> return
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curCell = queue.poll();
                for (int[] direction : directions) {
                    int[] nei = {curCell[0] + direction[0], curCell[1] + direction[1]};
                    if (nei[0] == x && nei[1] == y) {
                        return step;
                    }
                    if (!visited.contains(nei[0] + "," + nei[1])) {
                        queue.offer(nei);
                        visited.add(nei[0] + "," + nei[1]);
                    }
                }
            }
        }
        // return
        return -1;
    }

    public static void main(String[] args) {
        KnightMoves sol = new KnightMoves();
        System.out.print(sol.minKnightMoves(1, 1));
    }
}
