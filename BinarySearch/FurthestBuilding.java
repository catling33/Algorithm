package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int left = 0;
        int right = heights.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isReachable(mid, heights, bricks, ladders)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean isReachable(int buildingIndex, int[] heights, int bricks, int ladders) {
        List<Integer> climbs = new ArrayList<>();
        for (int i = 1; i <= buildingIndex; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                climbs.add(diff);
            }
        }
        Collections.sort(climbs);
        for (int climb : climbs) {
            if (climb <= bricks) {
                bricks -= climb;
            } else if (ladders >= 1) {
                ladders -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
