package String;

public class ReverseWordsStringIII {
    public String reverseWords(String s) {
        // sanity check
        if (s == null || s.length() == 0) {
            return s;
        }
        // convert string to char array
        char[] array = s.toCharArray();
        // [s, f) characters to reverse
        // initially, s == 0 & f == 0
        int slow = 0;
        int fast = 0;
        // iterate through s
        // f moves to a space
        // reverse characters [s, f)
        // s moves to f + 1
        while (slow < array.length) {
            while (fast < array.length && array[fast] != ' ') {
                fast++;
            }
            reverse(array, slow, fast - 1);
            slow = fast + 1;
            fast = slow;
        }
        // return string
        return new String(array);
    }
    // reverse
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsStringIII sol = new ReverseWordsStringIII();
        String s = "Let's take LeetCode contest";
        System.out.println(sol.reverseWords(s));
    }
}
