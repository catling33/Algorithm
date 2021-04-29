package HashTable;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {
    public int countNicePairs(int[] nums) {
        // sanity check
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        // mod
        int mod = (int)1e9 + 7;
        // record number of nice pairs
        int result = 0;
        // hashmap to store (num - reverse, frequency)
        Map<Integer, Integer> freqMap = new HashMap<>();
        // iterate through nums array
        // find reverse
        // put count of num - reverse int hashmap
        // add count to result
        for (int num : nums) {
            int rev = reverse(num);
            // get count of matched pairs with current entry
            int count = freqMap.getOrDefault(num - rev, 0);
            // update frequency in hashmap
            freqMap.put(num - rev, count + 1);
            // add count of matched pairs to result
            result = (result + count) % mod;
        }
        // return result
        return result;
    }
    // find reverse
    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }

    public static void main() {
        CountNicePairs sol = new CountNicePairs();
        int[] array = new int[]{42,11,1,97};
        int result = sol.countNicePairs(array);
        System.out.println(result);
    }
}

// TC = O(nloga)
// SC = O(n)
