package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // sanity check
        // stack to store index of left parenthesis and right parenthesis not paired
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(-1);
        // record max length
        int maxLength = 0;
        // iterate
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerFirst(i);
            } else if (s.charAt(i) == ')') {
                stack.pollFirst();
                if (stack.isEmpty()) {
                    stack.offerFirst(i);
                } else {
                    maxLength = Math.max(i - stack.peekFirst(), maxLength);
                }
            }
        }
        // return
        return maxLength;
    }
    public static void main(String[] args) {
        LongestValidParentheses sol = new LongestValidParentheses();
        int result = sol.longestValidParentheses("()(()");
        System.out.print(result);
    }
}
