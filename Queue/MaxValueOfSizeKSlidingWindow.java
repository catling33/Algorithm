package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxValueOfSizeKSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // sanity check
        // result array
        int[] result = new int[nums.length - k + 1];
        // track current
        int index = 0;
        // queue to store the index of max value
        Deque<Integer> queue = new ArrayDeque<>();
        // [i - k + 1, i] : sliding window
        // for each step
        for (int i = 0; i < nums.length; i++) {
            // deal with right:
            // if current element >= tail --> poll tails
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            // when tail is bigger than current element, offer current index to tail
            queue.offerLast(i);

            // deal with left;
            // remove outdated elements
            while (!queue.isEmpty() &&  queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }

            // add max to result
            if (i >= k - 1) {
                result[index++] = nums[queue.peekFirst()];
            }
        }
        // return result
        return result;
    }
}
