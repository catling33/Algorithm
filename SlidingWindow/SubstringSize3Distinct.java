package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubstringSize3Distinct {
    public int countGoodSubstrings(String s) {
        // sanity check
        if (s == null || s.length() == 0) {
            return 0;
        }
        // [i - 3 + 1, i] : sliding window of size 3
        // hashmap to record <letter, count>
        Map<Character, Integer> hashMap = new HashMap<>();
        // int distinct to record distinct letter in sliding window
        int distinctCount = 0;
        // int count to record result so far
        int result = 0;
        // for each step
        // add one from right end
        // remove one from left end
        // distinctCount == 3
        // count++
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            // deal with right
            hashMap.put(cur, hashMap.getOrDefault(cur, 0) + 1);
            if (hashMap.get(cur) == 1) {
                distinctCount++;
            } else if (hashMap.get(cur) == 2){
                distinctCount--;
            }

            // deal with left
            if (i >= 3) {
                cur = s.charAt(i - 3);
                hashMap.put(cur, hashMap.get(cur) - 1);
                if (hashMap.get(cur) == 0) {
                    distinctCount--;
                    hashMap.remove(cur);
                } else if (hashMap.get(cur) == 1) {
                    distinctCount++;
                }
            }

            if (distinctCount == 3) {
                result++;
            }

        }
        // return result
        return result;
    }

    public static void main(String[] args) {
        SubstringSize3Distinct sol = new SubstringSize3Distinct();
        String s = "xyzzaz";
        System.out.println(sol.countGoodSubstrings(s));
    }
}
