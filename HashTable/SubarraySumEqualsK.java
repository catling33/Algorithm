package HashTable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // use hashmap to store <sum, count>
        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        // iterate once
        // calculate cumulative sum from 0th index to ith index inclusively
        // if sum - k exists in hashmap, add frequency to count
        // put sum into hashmap
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sumFreq.containsKey(sum - k)) {
                count += sumFreq.get(sum - k);
            }
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }
        // return count
        return count;
    }
}
