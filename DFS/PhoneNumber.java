package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    public List<String> letterCombinations(String digits) {
        // result array list
        List<String> result = new ArrayList<>();

        // sanity check
        if (digits == null || digits.length() == 0) {
            return result;
        }
        // string builder for solution prefix
        StringBuilder sb = new StringBuilder();

        // dictionary
        Map<Character, String> dictionary = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );

        // DFS
        DFS(0, sb, result, digits, dictionary);
        // return
        return result;
    }
    // DFS function
    private void DFS(int index, StringBuilder sb, List<String> result, String digits,
                     Map<Character, String> dictionary) {
        // base case
        if (index == digits.length()) {
            result.add(new String(sb));
            return;
        }
        // append a letter
        char digit = digits.charAt(index);
        String letters = dictionary.get(digit);
        for (char letter : letters.toCharArray()) {
            // append
            sb.append(letter);
            // next recrusion
            DFS(index + 1, sb, result, digits, dictionary);
            // remove
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
