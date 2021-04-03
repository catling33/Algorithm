package DynamicProgramming;

import java.util.TreeSet;

public class MaxSubarraySumMod {
    // Complete the maximumSum function below.
    // https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
    static long maximumSum(long[] a, long m) {
        // sanity check
        if (a == null || a.length == 0) {
            return 0;
        }
        // record max sum
        long maxSum = 0;

        // TreeSet to record prefix sum
        TreeSet<Long> prefixSet = new TreeSet<>();

        // record current sum
        long curSum = 0;

        // iterate
        // update current sum
        // update max sum
        // search for smallest larger prefix sum
        // update max sum
        // add current sum to prefix sum treeset
        for (int i = 0; i < a.length; i++) {
            curSum = (curSum + a[i] % m) % m;
            maxSum = Math.max(maxSum, curSum);

            Long prefix = prefixSet.higher(curSum);
            if (prefix != null) {
                maxSum = Math.max(maxSum, (curSum - prefix + m) % m);
            }

            prefixSet.add(curSum);
        }
        // return max sum
        return maxSum;
    }
}
