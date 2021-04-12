package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // sanity check
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        // hashmap to record letter and frequency in sliding window
        Map<Character, Integer> freqMap = new HashMap<>();
        // record maxLength
        int maxLength = 0;
        // [i, j) : sliding window
        int i = 0;
        int j = 0;
        // for each step
        // if count <= k , add right elements
        // if count > k, pop from left end
        while (j < s.length()) {
            if (freqMap.isEmpty() || freqMap.size() <= k) {
                char right = s.charAt(j);
                freqMap.put(right, freqMap.getOrDefault(right, 0) + 1);
                j++;
            }
            while (i < s.length() && freqMap.size() > k) {
                char left = s.charAt(i);
                int freq = freqMap.get(left);
                if (freq == 1) {
                    freqMap.remove(left);
                } else {
                    freqMap.put(left, freq - 1);
                }
                i++;
            }
            maxLength = Math.max(maxLength, j - i);
        }
        // return maxLength
        return maxLength;
    }
}
