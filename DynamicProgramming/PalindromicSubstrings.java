package DynamicProgramming;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        // sanity check
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        // dp matrix
        boolean[][] dp = new boolean[s.length()][s.length()];
        // record answer
        int result = 0;
        // base case
        // one character
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                    result++;
                } else if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    result++;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        // return
        return result;
    }

    public static void main(String[] args) {
        PalindromicSubstrings sol = new PalindromicSubstrings();
        String s = "aabaa";
        System.out.print(sol.countSubstrings(s));
    }
}
