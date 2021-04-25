package Math;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // sanity check
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // count number of negative signs
        int negative = 2;
        if (dividend < 0) {
            dividend = -dividend;
            negative--;
        }
        if (divisor < 0) {
            divisor = -divisor;
            negative--;
        }
        // count number of divisors can be found in dividend
        int count = 0;
        // return count with sign
        while (dividend - divisor >= 0) {
            count++;
            dividend -= divisor;
        }
        return negative == 1 ? -count : count;
    }
}
