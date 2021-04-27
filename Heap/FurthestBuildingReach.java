package Heap;

import java.util.PriorityQueue;

public class FurthestBuildingReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // sanity check
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return 1;
        }
        // minHeap to store heights to climb
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // iterate through array of heights
        // store height to climb in the minHeap
        // if minHeap size > ladders
        // pop the min value from minHeap
        // deduct min value from bricks
        // if bricks < 0
        // return i - 1
        for (int i = 1; i < heights.length; i++) {
            int height = heights[i] - heights[i - 1];
            if (height > 0) {
                minHeap.offer(height);
                if (minHeap.size() > ladders) {
                    int minHeight = minHeap.poll();
                    bricks -= minHeight;
                    if (bricks < 0) {
                        return i - 1;
                    }
                }
            }
        }
        // finished visiting all heights -> return last index
        return heights.length - 1;
    }
}
