package DynamicProgramming;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // sanity check
        // dp[i] represents the length of the longest valid substring ending at ith index
        int[] dp = new int[s.length()];
        // record max length
        int max = 0;
        // base case
        // induction rule
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        // return
        return max;
    }
    public static void main(String[] args) {
        LongestValidParentheses sol = new LongestValidParentheses();
        System.out.println(sol.longestValidParentheses("()"));
    }
}
