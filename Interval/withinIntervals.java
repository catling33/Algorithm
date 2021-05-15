package Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class withinIntervals {
    public boolean withinIntervals(int[][] intervals, int n) {
        // assume intervals matrix is not null or empty

// merge intervals
        List<int[]> mergedList = mergeIntervals(intervals);

        // check if n is within intervals using binary search
        return search(mergedList, n);
    }

    // merge intervals function
    private List<int[]> mergeIntervals(int[][] intervals) {
        // sort intervals in ascending order of start values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // list to store merged intervals
        List<int[]> mergedList = new ArrayList<>();

        // initialize
        mergedList.add(intervals[0]);

        // for each interval, merge if it overlaps
        // with the last interval in the merged list
        // otherwise, append to merged list
        for (int[] interval : intervals) {
            int[] lastInterval = mergedList.get(mergedList.size() - 1);
            if (interval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
                mergedList.add(interval);
            }
        }
        return mergedList;
    }

    // binary search function to find if n is in the intervals
    private boolean search(List<int[]> mergedList, int n) {
        // result interval form binary search
        int[] result = null;

        // initialize boundaries
        int left = 0;
        int right = mergedList.size() - 1;

        // search for interval with greatest start value smaller or equals to n
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int[] midInterval = mergedList.get(mid);
            if (midInterval[0] == n) {
                result = midInterval;
                break;
            } else if (midInterval[0] <= n) {
                left = mid;
            } else {
                right = mid;
            }
        }

// post processing
        if (mergedList.get(right)[0] <= n) {
            result = mergedList.get(right);
        } else if (mergedList.get(left)[0] <= n) {
            result = mergedList.get(left);
        }

// check if end time >= n
        if (result != null && result[1] >= n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        withinIntervals sol = new withinIntervals();
        int[][] intervals = {{1, 4}, {1, 5}, {7, 10}, {14, 20}}; //
        System.out.println(sol.withinIntervals(intervals, 6));

    }
}
