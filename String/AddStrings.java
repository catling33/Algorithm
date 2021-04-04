package String;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int value = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;
            result.append(value);
        }

        if (carry != 0) {
            result.append(carry);
        }

        return new String(result.reverse());
    }
}
