package DynamicProgramming;

public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        // sanity check
        if (strs == null || strs.length == 0) {
            return 0;
        }
        // dp[i][j] represents the max number of strings with at most i zeros and at most j ones
        int[][] dp = new int[m + 1][n + 1];
        // base case
        dp[0][0] = 0;
        // induction rule
        for (String cur : strs) {
            int[] count = getCount(cur);
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i - count[0] >= 0 && j - count[1] >= 0) {
                        dp[i][j] = Math.max(dp[i - count[0]][j - count[1]] + 1, dp[i][j]);
                    }
                }
            }
        }

        // return
        return dp[m][n];
    }
    // get count
    private int[] getCount(String s) {
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        return count;
    }
}
