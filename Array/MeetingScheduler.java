package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // result array list
        List<Integer> result = new ArrayList<>();
        // sanity check
        if (slots1 == null || slots2 == null || duration == 0) {
            return result;
        }
        // sort
        Comparator<int[]> cmp = Comparator.comparing(p -> p[0]);
        Arrays.sort(slots1, cmp);
        Arrays.sort(slots2, cmp);
        // i and j pointers
        int i = 0;
        int j = 0;
        // for each step
        // get overlapping period
        // advance the one that ends early
        while (i < slots1.length && j < slots2.length) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (end - start >= duration) {
                result.add(start);
                result.add(start + duration);
                return result;
            }

            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        // return empty list
        return result;
    }
}
