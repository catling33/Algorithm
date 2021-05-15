package DFS;

import java.util.*;

public class TelephonePadI {
    public String[] combinations(int number) {
        // sanity check
        if (number < 0) {
            return null;
        }

        // String[] array to store pad
        String[] pad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // string builder to record prefix of current result
        StringBuilder sb = new StringBuilder();

        // convert number to string
        String input = Integer.toString(number);

        // result array list
        List<String> list = new ArrayList<>();

        // dfs
        dfs(0, input, sb, list, pad);

        // return
        return list.toArray(new String[0]);
    }

    private void dfs(int index, String input, StringBuilder sb, List<String> list, String[] pad) {
        // base case
        if (index == input.length()) {
            list.add(sb.toString());
            return;
        }

        // cur digit
        int digit = input.charAt(index) - '0';
        // cur letters to choose
        String letters = pad[digit];
        if (letters.length() == 0) {
            dfs(index + 1, input, sb, list, pad);
        } else {
            for (int i = 0; i < letters.length(); i++) {
                char letter = letters.charAt(i);
                sb.append(letter);
                dfs(index + 1, input, sb, list, pad);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public static void main(String[] args) {
        TelephonePadI sol = new TelephonePadI();
        System.out.print(Arrays.toString(sol.combinations(231)));
    }
}
