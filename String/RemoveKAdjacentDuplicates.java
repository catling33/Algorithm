package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKAdjacentDuplicates {
    public String removeDuplicates(String s, int k) {
        // sanity check
        if (s == null || s.length() <= 1) {
            return s;
        }
        // convert to char array
        char[] array = s.toCharArray();
        // stack to store count of duplicates for the last element we want to keep so far(input[i - 1])
        Deque<Integer> stack = new ArrayDeque<>();
        // [0, i) elements to keep
        int i = 0;
        // [j, size - 1] elements to explore
        int j = 0;

        // for each step, i++, j++
        while (j < array.length) {
            // if i == 0 or [j] != [i - 1]
            if (i == 0 || array[j] != array[i - 1]) {
                // keep current element --> [j] = [i]
                array[i] = array[j];
                // stack.push(1)
                stack.offerLast(1);
            } else { // if [j] == [i - 1]
                // increment count of duplicates for [i - 1]
                int count = stack.pollLast();
                count++;
                if (count == k) { // if count == k
                    i -= k; // delete duplicates
                } else { // if count < k
                    // keep current element
                    array[i] = array[j];
                    // offer updated count back to stack
                    stack.offerLast(count);
                }
            }
            i++;
            j++;
        }
        // return [0, i)
        return new String(array, 0, i);
    }
}
