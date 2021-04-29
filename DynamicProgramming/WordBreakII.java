package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    // dp class
    class DP {
        boolean isWord;
        List<String> list;

        DP() {
            isWord = false;
            list = new ArrayList<String>();
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        // result array list
        List<String> result = new ArrayList<>();
        // sanity check
        if (wordDict == null || wordDict.size() == 0 || s == null || s.length() == 0) {
            return result;
        }
        // set to store all words
        Set<String> dictionary = new HashSet<>();
        for (String word : wordDict) {
            dictionary.add(word);
        }
        // DP[] dp : do[i].isWord represent if first i characters can be formed by words, dp[i].list stores all possible combination
        DP[] dp = new DP[s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new DP();
        }
        // base case
        dp[0].isWord = true;
        // induction rule
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j].isWord && dictionary.contains(word)) {
                    dp[i].isWord = true;
                    // add substring to all combinations in the list
                    List<String> list = dp[j].list;
                    if (list.isEmpty()) {
                        dp[i].list.add(word);
                    } else {
                        for (String str : list) {
                            StringBuilder sb = new StringBuilder(str); // O(L)
                            sb.append(" ").append(word);
                            dp[i].list.add(sb.toString());
                        }
                    }
                }
            }
        }
        // return
        return dp[s.length()].list;
    }
}


// TC = O(n^2 + 2^n + W), W = number of words in the dictionary
// SC = O(2^n * n + W)