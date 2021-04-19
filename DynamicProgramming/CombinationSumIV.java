package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        // dp[i] represent the number of combinations to form i
        int[] dp = new int[target + 1];
        // base case
        dp[0] = 1;
        // induction rule
        // for each num in nums, add the dp result of complement
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        // return dp[target]
        return dp[target];
    }
    // TC = O(N * k)
    // SC = O(N)
}
